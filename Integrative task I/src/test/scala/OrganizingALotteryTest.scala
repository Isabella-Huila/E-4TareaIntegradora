

class OrganizingALotteryTest extends munit.FunSuite {

  val lotteryInstance = new OrganizingALottery()

  def setupStage1: List[(Int, Int)] = List((1, 2), (3, 4), (5, 6))

  def setupStage2: List[(Int, Int)]= List()

  def setupStage3: List[Int]= List()

  def setupStage4: List[Int]= List(3, 1, 4, 2)

  def setupStage5: List[Int]= List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  def setupStage6: List[(Int, Int)]= List((0, 5), (7, 10))

  def setupStage7: List[(Int, Int)]= List((-10, 10))

  def setupStage8: List[(Int, Int)]= List((0, 5), (-3 , 2), (7 , 10))


  // SEPARATETUPLES //

  test("separateTuples") {
    val input1 = setupStage1
    val expectedOutput = (List(1, 3, 5), List(2, 4, 6))
    val result = lotteryInstance.separateTuples(input1)
    assertEquals(result, expectedOutput)
  }

  test("separateTuples with empty input") {
    val input = setupStage2
    val expectedOutput = (List.empty[Int], List.empty[Int])
    val result = lotteryInstance.separateTuples(input)
    assertEquals(result, expectedOutput)
  }

  // MERGESORT

  test("mergeSort with an empty list") {
    val input = setupStage3
    val expectedOutput = List.empty[Int]
    val result = lotteryInstance.mergeSort(input)
    assertEquals(result, expectedOutput)
  }

  test("mergeSort with unsorted input") {
    val input = setupStage4
    val expectedOutput = List(1, 2, 3, 4)
    val result = lotteryInstance.mergeSort(input)
    assertEquals(result, expectedOutput)
  }

  test("binarySearchLessThanOrEqual with lessThan equal to true") {
    val arr = setupStage5
    val expectedOutput = 5
    val result = lotteryInstance.binarySearchLessThanOrEqual(arr, 5, 0, arr.length-1, true)
    assertEquals(result, expectedOutput)
  }

  test("binarySearchLessThanOrEqual with lessThan equal to false") {
    val arr = setupStage5
    val expectedOutput = 4
    val result = lotteryInstance.binarySearchLessThanOrEqual(arr, 5, 0, arr.length - 1, false)
    assertEquals(result, expectedOutput)
  }

  test("organizeLotteryT1") {
    val segments = setupStage6
    val points = List(1, 6 , 11)
    val expectedOutput = List(1, 0, 0)
    val result = lotteryInstance.organizeLottery(segments, points)
    assertEquals(result, expectedOutput)
  }

  test("organizeLotteryT2") {
    val segments = setupStage7
    val points = List(- 100 , 100 , 0)
    val expectedOutput = List(0, 0, 1)
    val result = lotteryInstance.organizeLottery(segments, points)
    assertEquals(result, expectedOutput)
  }

  test("organizeLotteryT3") {
    val segments = setupStage8
    val points = List(1 , 6)
    val expectedOutput = List(2, 0)
    val result = lotteryInstance.organizeLottery(segments, points)
    assertEquals(result, expectedOutput)
  }

}
