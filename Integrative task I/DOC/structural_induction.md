

## Problem 2: Majority element

Structural Induction:
For this problem we turn to the findMajority function in the context of the problem of finding a majority element in a list.

**Step 1: Base Step**
The base case is when the list is empty (`Nil`). In this case, the `findMajority(list)` function should return -1 since there are no elements in the list and therefore there cannot be a majority element.
Therefore, for the base case, we have:
Empty list= λ
P(λ) = findMajority(Nil) = -1

**Step 2: Inductive Hypothesis**
For k in the natural numbers, suppose that P(k) is true, where P(k) is defined as follows:
P(k): The findMajority(list) function is correct for a list of length k.
This means that for a list of length k , the `findMajority(list)` function returns the majority element if it exists, or -1 if it does not exist. prove that the function is correct for a list of length k+1.
**Step 3: Recursive Step**
We want to test that the findMajority(list) function is correct for a list of length k+1 . To do this, we must consider two cases:
**Case 1:** There is a majority element in the list of length k+1.
If there exists a majority element in a list L of length k+1, then findMajority(L) must be equal to that majority element. In this case, the function `findMajority(list)` should be able to detect that majority element and return it .
**Case 2:** There is no majority element in the list of length k+1
The `findMajority(list)` function should return -1 to indicate that there is no majority element. If there is no majority element in a list L of length k+1, then findMajority(L) must be equal to -1.

We have shown by structural induction that the function findMajority(list) is correct for lists of any length k in the set of natural numbers. Formally, we have established the following:

- **Base Step:** For k = 0, the findMajority(list) function is correct, since it returns -1 when the list is empty, which is consistent with the definition of the P(0) property.

- **Recursive step:** Assuming that P(k) is true for some arbitrary k, we have shown that \( P(k+1) \) is also true for lists of length k+1. This has been demonstrated by the cases where a majority element does or does not exist in the list of length k+1 , and in both cases the function findMajority(list) behaves correctly, satisfying the definition P(k+1 ).
