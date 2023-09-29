import munit.FunSuite

class BinarySearchTest extends FunSuite {

  test("binarySearch should return the correct numbers") {
    val a = List(1, 5, 8, 12, 13)
    val b = List(8, 1, 23, 1, 11)

    val result = BinarySearch.binarySearch(a, b)
    val expected = List(2, 0, -1, 0, -1)
    assertEquals(result, expected)
  }

  test("binarySearch should return -1 for elements not found") {
    val a = List(1, 2, 3, 4, 5)
    val b = List(6, 7, 8, 9)

    val result = BinarySearch.binarySearch(a, b)
    val expected = List(-1, -1, -1, -1)
    assertEquals(result, expected)
  }

  test("binarySearch should return the correct numbers for a different entry") {
    val a = List(2, 4, 6, 8, 10)
    val b = List(4, 6, 10, 12)

    val result = BinarySearch.binarySearch(a, b)
    val expected = List(1, 2, 4, -1)
    assertEquals(result, expected)
  }
}