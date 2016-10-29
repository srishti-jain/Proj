package testers

import org.scalatest.WordSpec
import swappingSchemes.LruCache

class TestingLruCache extends WordSpec {
  val testCache = new LruCache [String, Long]//create cache
  //fill cache with 5 strings
  testCache.insertPair("string1", 1)
  testCache.insertPair("string2", 2)
  testCache.insertPair("string3", 3)
  testCache.insertPair("string4", 4)
  testCache.insertPair("string5", 5)

  "A Key" when {
    "cached" should {
      assert(testCache.getValueIfExists("string1").isDefined)
      assert(testCache.getValueIfExists("string3").isDefined)
      println("All tests for keys that are cached pass")
    }
  }
  "not cached" should {
    testCache.insertPair("string6", 6)
    testCache.insertPair("string7", 7)
    assert(testCache.getValueIfExists("string2").isEmpty)
    assert(testCache.getValueIfExists("string4").isEmpty)
    println("All tests for keys that are not cached pass")
  }
  println("All tests for LRU pass")
}
