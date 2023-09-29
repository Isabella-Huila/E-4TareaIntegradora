# Format tests

## Configuration of the Scenarios

| Name         | Class      | Stage                                                                            |
|--------------|------------|----------------------------------------------------------------------------------|
| setupStange1 | Organizing | a list of tuples with the following elements: <br/> List((1, 2), (3, 4), (5, 6)) |
| setupStange2 | Organizing | a list of tuples empty: List()                                                   |
| setupStange3 | Organizing | a list of tuples empty: List()                                                   |
| setupStange4 | Organizing | a list with the following elements: List(3, 1, 4, 2)                             |
| setupStange5 | Organizing | a list with the following elements: List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)          |
| setupStange6 | Organizing | a list of tuples with the following elements: List((0, 5), (7, 10))              |
| setupStange7 | Organizing | a list of tuples with the following elements: List((-10, 10))                    |
| setupStange8 | Organizing | a list of tuples with the following elements: List((0, 5), (-3 , 2), (7 , 10))   |
## Test Case Design

Objective of the Test: verify the method that organizes a lottery and calculates the number of segments that each point contains, 
with its auxiliary functions

| Class               | Method                      | Stage        | Input Values                                                                       | Expected result                                                                                                                           |
|---------------------|-----------------------------|--------------|------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------|
| OrganizingALottery  | separateTuples              | setupStange1 | List((1,2),(3,4),(5,6))                                                            | separate into two lists, one containing the start point and the other the end point, thus leaving : <br/> List(1, 3, 5) and List(2, 4, 6) |
| OrganizingALottery  | separateTuples              | setupStange2 | List()                                                                             | separate into two lists that are empty                                                                                                    |
| OrganizingALottery  | mergeSort                   | setupStange3 | List()                                                                             | empty list expected                                                                                                                       |
| OrganizingALottery  | mergeSort                   | setupStange4 | List(3, 1, 4, 2)                                                                   | An ordered list is expected as follows: List(1, 2, 3, 4)                                                                                  |
| OrganizingALottery  | binarySearchLessThanOrEqual | setupStange5 | arr=List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), target=5, left=0, right=9, lessThan= true | It starts with the amount of numbers that are less than and equal to the objective, in this case: 5                                       |
| OrganizingALottery  | binarySearchLessThanOrEqual | setupStange5 | arr=List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), target=5, left=0, right=9, lessThan= true | It starts with the amount of numbers that are less than the objective, in this case: 4                                                    |
| OrganizingALottery  | organizeLottery             | setupStange6 | segments= List((0, 5), (7, 10)), points= List(1, 6 , 11)                           | It is expected to return a list with the number of segments in which each point is, in this case it would be: List(1, 0, 0)               |
| OrganizingALottery  | organizeLottery             | setupStange7 | segments= List((-10, 10)), points= List(- 100 , 100 , 0)                           | It is expected to return a list with the number of segments in which each point is, in this case it would be: List(0, 0, 1)               |
| OrganizingALottery  | organizeLottery             | setupStange8 | segments= List((0, 5), (-3 , 2), (7 , 10)), points= List(1 , 6)                    | It is expected to return a list with the number of segments in which each point is, in this case it would be: List(2, 0)                  |

# Problem 2: Majority element
## Configuration of the Scenarios

| Name | Class           | Stage                                                                                                                                                                                             |
|------|-----------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| divid.MajorityElement with empty list     | divid.MajorityElement | setupStage1: is a list empty                                                                                                                                                                      |
|  divid.MajorityElement with a element 2 sample of the integrative task    | divid.MajorityElement | setupStage2: It is a sequence of 5 numbers that are (2,3, 9, 2, 2) as in the example of the Integrator task                                                                                       |
|   divid.MajorityElement with majority of 2   | divid.MajorityElement | setupStage3: It is a sequence of 7 numbers that are (1, 2, 2, 2, 3, 2, 2) where its majority element is 2                                                                                         |
| divid.MajorityElement with a single element     | divid.MajorityElement | setupStage4: It is a sequence of a single element where the majority element is the same                                                                                                          |
|  divid.MajorityElement with majority of 1    | divid.MajorityElement | setupStage5: It is a sequence of 8 elements, (1, 1, 1, 1, 2, 2) where the best element is 1                                                                                                       |
|   divid.MajorityElement with Numbers negative   | divid.MajorityElement | setupStage6 : It is a sequence of 5 numbers, but this sequence contains negative numbers, it should not get a majority number because there are negative numbers and there is no majority element |
|  ManjorityElement with 4 elements, sample of the integrative Task    | divid.MajorityElement | setupStage7 : It is a sequence of 4 numbers, just like in the example of the integrative task, it should be 0 since there is no majority element                                                                                                                                                                                    |
|      | divid.MajorityElement |                                                                                                                                                                                                   |
## Test Case Design

Objective of the Test:It is necessary to test if the method of finding the majority element is doing it correctly.

| Class           | Method          | Stage       | Input Values   | Expected result   |
|-----------------|-----------------|-------------|------------------|---------------------|
| divid.MajorityElement | majorityElement | setupStage1 |       List.empty            |      that does not return a majority element or is 0               |
| divid.MajorityElement | majorityElement | setupStage2 |        List(2,3, 9, 2, 2)          |    That returns a majority element, which would be the number 2                 |
| divid.MajorityElement | majorityElement | setupStage3 |    List(1, 2, 2, 2, 3, 2, 2)              |     That returns a majority element, which would be the number 2, but in a larger sequence                |
| divid.MajorityElement | majorityElement | setupStage4 |      List(1)            |    that returns the only majority element in the list                 |
| divid.MajorityElement | majorityElement | setupStage5 |     List(1, 1, 1, 1, 2, 2,3)             |     Which returns a majority element in a sequence of 8                |
 | divid.MajorityElement | majorityElemnt  | setupStage6 |     List(-1, 2, 3, -4, 5)             |    That it does not return anything, because there are negative numbers within the frequency                 | 
 | divid.MajorityElement | majorityElement | setupStage7 |       List( 1,2, 3, 1)           |         That returns 0 because there is no majority element, as in the example of the integrative task document            |  
# Problema 1 :  Binary search
## Configuration of the Scenarios

| Name | Class | Stage |
|------|-------|-------|
|BinarySearch|BinarySearch|setupStage1: Binary Search|
|InputValidation|BinarySearch|setupStage2: Testing input validation with valid and invalid lists|
|Deployment|BinarySearch|setupStage3: Deployment of the program for production use|
|BinarySearch with a 2 input sample as in the integratos|BinarySearch|setupStage4: It is an input of 5 1 5 5 8 12 13 and the second input is 5 8 1 23 1 11 as the integrator example| 
|BinarySearch with other values|BinarySearch|setupStage5: It is an input of 1 5 8 12 13 and the second input is 8 1 23 1 11|

## Test Case Design

Objective of the Test:

| Class | Method | Stage | Input Values   | Expected result   |
|---------|----------|---------|------------------|---------------------|
|BinarySearchTest|binarySearch should return the correct numbers|setupStage1|List(1 5 8 12 13), List(8 1 23 1 11)|List(2 0 -1 0 - 1)|
|BinarySearchTest|binarySearch should return -1 for elements not found|setupStage2|List(1 2 3 4 5), List(6, 7, 8, 9)|List(-1 -1 -1 -1)|
|BinarySearchTest|binarySearch should return the correct numbers for a different entry|setupStage3|List(2 4 6 8 10), List(4 6 10 12)|List(1 2 4 -1)|
