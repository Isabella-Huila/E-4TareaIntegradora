import divid.MajorityElement

class MajorityElementTest extends munit.FunSuite {

  def setupStage1: List[Int] = List.empty[Int] // Lista vacía

  def setupStage2: List[Int] = List(2,3, 9, 2, 2)

  def setupStage3: List[Int] = List(1, 2, 2, 2, 3, 2, 2)

  def setupStage4: List[Int] = List(1) // List with a element

  def setupStage5: List[Int] = List(1, 1, 1, 1, 2, 2,3)

  def setupStage6: List[Int] = List(-1, 2, 3, -4, 5) // List with numbers nefative

  def setupStage7: List[Int] = List( 1,2, 3, 1)

  val majorityElementInstance = new MajorityElement()

  test("divid.MajorityElement with empty list") {
    val input = setupStage1
    val expectedOutput = 0
    val result = majorityElementInstance.majorityElement(input)
    assertEquals(result, expectedOutput)
  }

  test("divid.MajorityElement with a element 2 sample of the integrative task") {
    val input = setupStage2
    val expectedOutput = 1
    val result = majorityElementInstance.majorityElement(input)
    assertEquals(result, expectedOutput)
  }

  test("divid.MajorityElement with majority of 2 ") {
    val input = setupStage3
    val expectedOutput = 1
    val result = majorityElementInstance.majorityElement(input)
    assertEquals(result, expectedOutput)
  }

  test("divid.MajorityElement with a single element") {
    val input = setupStage4
    val expectedOutput = 1
    val result = majorityElementInstance.majorityElement(input)
    assertEquals(result, expectedOutput)
  }

  test("divid.MajorityElement with majority of 1") {
    val input = setupStage5
    val expectedOutput = 1
    val result = majorityElementInstance.majorityElement(input)
    assertEquals(result, expectedOutput)
  }

  test("divid.MajorityElement with Numbers negative") {
    val input = setupStage6
    val expectedOutput = 0 // because have numbers negative
    val result = majorityElementInstance.majorityElement(input)
    assertEquals(result, expectedOutput)
  }

  test("ManjorityElement with 4 elements, sample of the integrative Task"){
    val input = setupStage7
    val expectedOutput = 0
    val result = majorityElementInstance.majorityElement(input)
    assertEquals(result, expectedOutput)
  }


}
