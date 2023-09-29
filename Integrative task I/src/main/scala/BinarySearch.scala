import scala.annotation.tailrec
/**
 * This object performs a binary search on two lists of integers.
 */
object BinarySearch {

  /**
   * Main program entry.
   *
   * @param args are not used
   */
  def main(args: Array[String]): Unit = {
    // Reads the first list of integers and separates the first element x from the rest y
    val inputX = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList
    val x = inputX.head
    val y = inputX.tail

    // Reads the second list of integers and separates the first element a from the rest b
    val inputY = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList
    val a = inputY.head
    val b = inputY.tail

    // Performs binary search and stores the solution
    val solution = binarySearch(y, b)

    // displays the solution as a text string
    println(solution.mkString(" "))
  }

  /**
   * Performs a binary search on two lists of integers.
   *
   * @param a The first list to search in.
   * @param b The second list containing elements to search.
   * @return A list of integers representing the positions of the items in list a found in list b.
   */
  def binarySearch(a: List[Int], b: List[Int]): List[Int] = {

    /**
     * Recursive binary search function.
     *
     * @param key  The element to search for.
     * @param low  The low number of the current search range.
     * @param high The high number in the current search range.
     * @return The position of the element in the a list or -1 if not found.
     */
    @tailrec
    def search(key: Int, low: Int, high: Int): Int = {
      if (low > high) -1
      else {
        val mid = low + (high - low) / 2
        if (a(mid) == key) mid
        else if (a(mid) < key) search(key, mid + 1, high)
        else search(key, low, mid - 1)
      }
    }

    /**
     * Recursive binary search for each element of the list b.
     *
     * @param a   The list to search in.
     * @param b   The list containing elements to search.
     * @param acc Acc Accumulator to store the search results.
     * @return A list of integers representing the positions of the items from list a found in list b.
     */
    @tailrec
    def binaryRecursive(a: List[Int], b: List[Int], acc: List[Int]): List[Int] = {
      b match {
        case Nil => acc.reverse
        case key :: tail =>
          val result = search(key, low = 0, a.length - 1)
          binaryRecursive(a, tail, result +: acc)
      }
    }
    binaryRecursive(a, b, Nil)
  }
}