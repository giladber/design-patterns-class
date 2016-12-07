package patterns.fp

import scala.concurrent.duration.FiniteDuration

/**
  * Created by giladrber on 12/7/2016.
  */
trait TimedMap[K, V] {
  def put(key: K, value: V, duration: FiniteDuration)
  def get(key: K): Option[V]
}
