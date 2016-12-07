package patterns.fp

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import patterns.fp.Messages.{AddMessage, GetMessage, RemoveMessage}

import scala.concurrent.{Await, Future, duration}
import scala.concurrent.duration.{Duration, DurationInt, FiniteDuration}

/**
  */
class TimedHashMap[K, V] extends TimedMap[K, V] {
  val system = ActorSystem("design-patterns")
  val actor: ActorRef = system.actorOf(Props[MapActor[K, V]]())
  implicit val timeout: Timeout = 5 seconds


  override def put(key: K, value: V, duration: FiniteDuration): Unit = {
    actor ! AddMessage(key, value, duration)
  }

  override def get(key: K): Option[V] = {
    val future: Future[Option[V]] = (actor ? GetMessage(key)).mapTo[Option[V]]
    Await.result(future, Duration(5, duration.SECONDS))
  }
}

class MapActor[K, V] extends Actor {
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.collection.mutable
  type ValueWithTimestamp = (V, Long)

  val map: mutable.Map[K, ValueWithTimestamp] = mutable.Map()

  override def receive: Receive = {
    case AddMessage(key: K, value: V, duration: FiniteDuration)  =>
      val timeStamp = duration.toNanos + System.nanoTime()
      map += ((key, (value, timeStamp)))
      context.system.scheduler.scheduleOnce(duration) {
        self ! RemoveMessage(key, value, timeStamp)
      }

    case RemoveMessage(key: K, expectedValue: V, expectedTimestamp: Long) =>
      map.get(key)
        .filter( result => result._1 == expectedValue && result._2 <= expectedTimestamp )
        .foreach(result => map.remove(key))

    case GetMessage(key: K) =>
      sender() ! map.get(key).map(_._1)
  }
}

object Messages {
  sealed trait ControlMessage
  case class AddMessage[K, V](key: K, value: V, duration: FiniteDuration) extends ControlMessage
  case class RemoveMessage[K, V](key: K, expectedValue: V, expectedTimestamp: Long) extends ControlMessage
  case class GetMessage[K](key: K) extends ControlMessage
}
