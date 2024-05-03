**Easy**

1. **Linear Search**
Find the first occurrence of a target element in
an array.

```java
int[] arr = {2, 5, 8, 12, 16};
int target = 8;
int result = linearSearch(arr, target);
System.out.println(result); // Output: 2
```

2. **Reverse Array**
Reverse the elements of an array.

```java
int[] arr = {1, 2, 3, 4, 5};
int[] reversedArr = reverseArray(arr);
for (int i : reversedArr) {
    System.out.print(i + " ");
} // Output: 5 4 3 2 1
```

**Medium**

1. **Bubble Sort**
Sort an array of integers in ascending order
using bubble sort.

```java
int[] arr = {5, 2, 8, 3, 1};
arr = bubbleSort(arr);
for (int i : arr) {
    System.out.print(i + " ");
} // Output: 1 2 3 5 8
```

2. **Binary Search**
Find the index of a target element in a sorted
array using binary search.

```java
int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
int target = 5;
int result = binarySearch(arr, target);
System.out.println(result); // Output: 4
```

**Hard**

1. **Merge Sort**
Sort an array of integers in ascending order
using merge sort.

```java
int[] arr = {5, 2, 8, 3, 1};
arr = mergeSort(arr);
for (int i : arr) {
    System.out.print(i + " ");
} // Output: 1 2 3 5 8
```

2. **Quick Sort**
Sort an array of integers in ascending order
using quick sort.

```java
int[] arr = {5, 2, 8, 3, 1};
arr = quickSort(arr);
for (int i : arr) {
    System.out.print(i + " ");
} // Output: 1 2 3 5 8
```

Let me know if you want more questions or a
specific type of algorithm!

>>> 8
You've chosen the Binary Search question!

Here's the problem:

Find the index of a target element in a sorted
array using binary search.

```
int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
int target = 5;
int result = binarySearch(arr, target);
System.out.println(result); // Output: ?
```

To solve this problem, you need to implement a
binary search algorithm. Here's the expected
output:

```
Output: 4
```

The target element `5` is located at index `4` in
the sorted array.

Now it's your turn! Write a Java method that
implements the binary search algorithm and finds
the index of the target element in the given
array.

Hint: You can start by dividing the array into
two halves, comparing the middle element with the
target, and then recursively searching one half
or the other until you find the target.
