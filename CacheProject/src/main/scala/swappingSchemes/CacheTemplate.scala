package swappingSchemes

import scala.collection.mutable

trait CacheTemplate[Key, Value] {
  val size: Int = 5 //size of cache
  val cache: mutable.LinkedHashMap[Key, Value] = mutable.LinkedHashMap()

  def getValueIfExists(key: Key): Option[Value] //defined in inheritors
  def addPair(key: Key, value: Value) = cache += (key -> value)
  def insertPair(key: Key, value: Value) = {
    if (cache.size == size) {
      cache -= cache.keysIterator.next()
    }
    addPair(key, value)
  }
}
