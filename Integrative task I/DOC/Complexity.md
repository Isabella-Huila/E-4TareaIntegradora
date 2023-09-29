# Problem 2 : Majority element 

 **Recurrence equation**


 To summarize what the algorithm in problem two does, it looks to see if there is a majority element in a given sequence, and a majority element is one that appears more than half of the time in the list, using the divide and conquer approach. , since it is splitting the list into two halves on each recursive call, then compares the results of the left and right recursive calls to determine the majority element in each half.

So we have that at each level of recursion the algorithm divides the list into two halves of size n/2 and makes two recursive calls, then an n linear operation is performed to count the occurrences in the entire list, that is, the required time corresponds to count the occurrences of the elements in the list which is done with the countOcurrences function.

Besides

Therefore, the recurrence equation is as follows:

T(n) = 2T(n/2) + n

This recursion equation reflects the behavior of the algorithm, where at each level of recursion the list is divided into two halves and a linear operation is performed on the entire list. Therefore, the total execution time is (n log n) in the worst case.

**Complexity of the algorithm using the master method:**

So we have the following:

T(n) = 2T(n/2) +n.

Where:

a = 2 (two recursive calls)

b = 2 (division into halves)

ε = 0.1

` `**First case:** Let's try the first case, which is when it is bounded above

n=О(n<b><sup>log</sup><sub>2</sub><sup>2-E</sup>)</b>

n=О(n<b><sup>1-0.1</sup>)</b>

n=О(n<b><sup>0.9</sup>)</b>

**Second Case:** When both are equal

n=ϴ(n <sup>log</sup><sub>2</sub><sup>2</sup>)

n=ϴ(n<b><sup>1</sup></b>)

n=ϴ(n)

**Third case:** When it is bounded Inferiorly, for this case a condition must be taken into account:

if af(n/b) cf(n) for some c<1

then it would be:

2* n/2 ≤ c*n

C= 0.9

**Would fit:**

n≤ 0.9*n, and we realize that it does not comply, therefore that would not be a possible solution.

**Answer:** An asymptotic estimate of the time complexity T(n) is
that is the second case.
T (n)= ϴ(n log n)