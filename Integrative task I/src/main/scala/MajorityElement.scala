

class MajorityElement {
  /**
   * Check whether the given sequence contains a majority element.
   * @param list The input sequence represented as a list of integers.
   * @return 1 if there is a majority element, 0 otherwise.
   */
  def majorityElement(list: List[Int]): Int = {

    /**
     * Recursively find the majority element in a sequence.
     * @param list The sequence to analyze.
     * @return The majority element if it exists, or -1 if there is not majority.
     */
    def findMajority(list: List[Int]): Int = {
      list match {
        case Nil => -1 // No majority element
        case x :: Nil => x
        case _ =>
          val (left, right) = list.splitAt(list.length / 2)

          val leftMajority = findMajority(left)
          val rightMajority = findMajority(right)

          if (leftMajority == rightMajority) {
            leftMajority
          } else {
            val leftCount = countOccurrences(list, leftMajority)
            val rightCount = countOccurrences(list, rightMajority)

            if (leftCount > list.length / 2) leftMajority
            else if (rightCount > list.length / 2) rightMajority
            else -1
          }
      }
    }
    /**
     * Count occurrences of an element in a list.
     * @param list    The list in which to count occurrences.
     * @param actual The element to count.
     * @return The total count of occurrences of the element in the list.
     */
    def countOccurrences(list: List[Int], actual: Int): Int = {
      list match {
        case Nil => 0
        case head :: tail if head == actual => 1 + countOccurrences(tail, actual)
        case _ :: tail => countOccurrences(tail, actual)
      }
    }

    val result = findMajority(list)

    if (result != -1) 1 else 0
  }
}
object Main {
  def main(args: Array[String]): Unit = {
    var n = -1
    while (n < 0) {
      println("Enter the number of elements in the sequence")
      n = scala.io.StdIn.readInt()

      if (n < 0) {
        println("Error: The number of elements cannot be negative. Please try again.")
      }
    }

    var input: List[Int] = Nil

    while (input.length < n) {
      println(s"Enter ${n - input.length} numbers of the sequence separated by spaces:")

      val userInput = scala.io.StdIn.readLine()
      val numbers = userInput.split(" ").map(_.toInt).toList

      if (numbers.exists(_ < 0)) {
        println("Error: The sequence cannot contain negative numbers. Please try again.")
      } else {
        input = input ::: numbers
      }
    }

    val test = new MajorityElement()
    val result = test.majorityElement(input)

    if (result == 1) {
      println("1")
      println(s"${input.head} is the majority element")
    } else {
      println("0")
      println("There is no majority element in this sequence.")
    }
  }
}

