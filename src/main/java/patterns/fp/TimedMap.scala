package patterns.fp

import scala.concurrent.duration
import scala.concurrent.duration.FiniteDuration

/**
  * Created by giladrber on 12/7/2016.
  */
trait TimedMap[K, V] {
  def put(key: K, value: V, duration: FiniteDuration)
  def get(key: K): Option[V]
}

object MyApp {
  def main(args: Array[String]): Unit = {
    val map = new TimedHashMap[String, Int]
    map.put("one", 1, FiniteDuration(5, duration.SECONDS))

    println("value is: ")
    println(map.get("one").getOrElse("none"))
    Thread.sleep(5100)
    println("value #2 is: ")
    println(map.get("one").getOrElse("none"))
  }
}
