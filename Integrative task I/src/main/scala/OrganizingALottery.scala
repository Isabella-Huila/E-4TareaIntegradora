

import scala.annotation.tailrec
import scala.io.StdIn

class OrganizingALottery {

  /**
   * Separates a list of tuples into two lists, one containing the first elements of the tuples
   * and the other containing the second elements of the tuples.
   *
   * @param tupleList The input list of tuples to separate.
   * @return A tuple containing two lists: the first list contains the first elements
   *         of the input tuples, and the second list contains the second elements
   *         of the input tuples.
   */
  def separateTuples(tupleList: List[(Int, Int)]): (List[Int], List[Int]) = {
    /**
     * Helper function that performs the separation recursively.
     *
     * @param tuples   The remaining list of tuples to process.
     * @param startAcc Accumulator for the first elements of the tuples.
     * @param endAcc   Accumulator for the second elements of the tuples.
     * @return A tuple containing two lists: the first list contains the first elements
     *         of the input tuples, and the second list contains the second elements
     *         of the input tuples.
     */
    @tailrec
    def separateHelper(tuples: List[(Int, Int)], startAcc: List[Int], endAcc: List[Int]): (List[Int], List[Int]) = tuples match {
      case Nil => (startAcc.reverse, endAcc.reverse)
      case (start, end) :: tail =>
        separateHelper(tail, start :: startAcc, end :: endAcc)
    }

    separateHelper(tupleList, Nil, Nil)
  }

  /**
   * Sorts a list of integers using the merge sort algorithm.
   *
   * @param list The list of integers to be sorted.
   * @return A new list containing the integers sorted in ascending order.
   */
  def mergeSort(list: List[Int]): List[Int] = {
    /**
     * Helper function that performs the merge sort recursively.
     *
     * @param left  The left part of the list to be merged.
     * @param right The right part of the list to be merged.
     * @param acc   Accumulator for the merged list.
     * @return A new list containing the elements merged in ascending order.
     */
    @tailrec
    def merge(left: List[Int], right: List[Int], acc: List[Int]): List[Int] = (left, right) match {
      case (Nil, Nil) => acc.reverse
      case (Nil, rightTail) => merge(Nil, Nil, rightTail.head :: acc)
      case (leftHead :: leftTail, Nil) => merge(Nil, Nil, leftHead :: acc)
      case (leftHead :: leftTail, rightHead :: rightTail) =>
        if (leftHead <= rightHead) merge(leftTail, right, leftHead :: acc)
        else merge(left, rightTail, rightHead :: acc)
    }

    val n = list.length / 2
    if (n == 0) list
    else {
      val (left, right) = list.splitAt(n)
      merge(mergeSort(left), mergeSort(right), Nil)
    }
  }

  /**
   * Performs a binary search on a sorted list of integers to find the index of the target integer or its position.
   *
   * @param arr      The sorted list of integers to search.
   * @param target   The target integer to find or compare against.
   * @param left     The left index for the search range.
   * @param right    The right index for the search range.
   * @param lessThan If true, performs a search for elements less than or equal to the target.
   *                 If false, performs a search for elements less than the target.
   * @return The index of the target integer if found or its position in the sorted list.
   */
  def binarySearchLessThanOrEqual(arr: List[Int], target: Int, left: Int, right: Int, lessThan: Boolean): Int = {
    if (left > right)
      if (right < 0) 0
      else right + 1
    else
      val mid = left + (right - left) / 2
      if (lessThan)
        if (arr(mid) <= target)
          binarySearchLessThanOrEqual(arr, target, mid + 1, right, lessThan)
        else
          binarySearchLessThanOrEqual(arr, target, left, mid - 1, lessThan)
      else if (arr(mid) < target)
        binarySearchLessThanOrEqual(arr, target, mid + 1, right, lessThan)
      else
        binarySearchLessThanOrEqual(arr, target, left, mid - 1, lessThan)

  }

  /**
   * Subtracts an integer value `b` from another integer value `a`.
   *
   * @param a The first integer value.
   * @param b The second integer value to subtract from `a`.
   * @return The result of subtracting `b` from `a`.
   */
  def subtraction(a: Int, b: Int): Int = {
    a - b
  }


  /**
   * Organizes a lottery and calculates the number of segments containing each point.
   *
   * @param segments A list of segments defined by pairs of integers.
   * @param points   A list of integers representing points.
   * @return A list of integers representing the number of segments containing each point.
   */
  def organizeLottery(segments: List[(Int, Int)], points: List[Int]): List[Int] = {
    if (segments.isEmpty)
      Nil
    else
      val (startList, endList) = separateTuples(segments)
      mergeSort(startList)
      mergeSort(endList)
      points match
        case Nil => Nil
        case h :: t =>
          subtraction(binarySearchLessThanOrEqual(startList, h, 0, startList.length - 1, true),
            binarySearchLessThanOrEqual(endList, h, 0, endList.length - 1, false)) :: organizeLottery(segments, t)
  }
}


object main {
  def main(args: Array[String]): Unit = {
    val l = new OrganizingALottery

    println("Enter the number of segments and the number of points (separated by spaces):")
    val Array(numSegments, numPoints) = StdIn.readLine().split(" ").map(_.toInt)

    println("Enter the segments (start and end separated by spaces):")
    val segments = (1 to numSegments).map { _ =>
      val Array(start, end) = StdIn.readLine().split(" ").map(_.toInt)
      (start, end)
    }.toList

    println("Enter points:")
    val points = StdIn.readLine().split(" ").map(_.toInt).toList

    val results = l.organizeLottery(segments, points)

    println("Enter points:")
    println(results.mkString(" "))
  }
}
