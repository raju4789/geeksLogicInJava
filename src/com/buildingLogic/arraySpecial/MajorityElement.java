package com.buildingLogic.arraySpecial;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * Problem: Given an array of n elements containing duplicate elements, your
 * task is to find the majority element. An element is said to be majority if it
 * occurs more than n/2 times. Input: First line of input contains n, no. of
 * elements . Next line contains n space separated integers, elements of array.
 * Output: Print the majority element if exist else -1 Constraints: 0≤n≤1000
 * Sample Input: 9 3 3 4 2 4 4 2 4 4 Sample Output: 4
 * 
 * @author Raju Rockzz :P
 *
 */
/**
 * 
 * (Using Moore’s Voting Algorithm)
This is a two step process.

NOTE : This Method only works when we are given that majority element do exist in the array , otherwise this method won’t work , as in the problem definition we said that 
majority element may or may not exist but for applying this approach you can assume that majority element do exist in the given input array

The first step gives the element that may be majority element in the array. If there is a majority element in an array, then this step 
will definitely return majority element, otherwise it will return candidate for majority element.
Check if the element obtained from above step is majority element.This step is necessary as we are not always sure that element return by
 
first step is majority element.
1. Finding a Candidate :
The algorithm for first phase that works in O(n) is known as Moore’s Voting Algorithm. Basic idea of the algorithm is that if we cancel 
out each occurrence of an element e with all the other elements that are different from e then e will exist till end if it is a majority 
element.

findCandidate(a[], size)
1.  Initialize index and count of majority element
     maj_index = 0, count = 1
2.  Loop for i = 1 to size – 1
    (a) If a[maj_index] == a[i]
          count++
    (b) Else
        count--;
    (c) If count == 0
          maj_index = i;
          count = 1
3.  Return a[maj_index]

Above algorithm loops through each element and maintains a count of a[maj_index]. If the next element is same then increment the count, if 
the next element is not same then decrement the count, and if the count reaches 0 then changes the maj_index to the current element and set 
the count again to 1. So, the first phase of the algorithm gives us a candidate element.
In the second phase we need to check if the candidate is really a majority element. Second phase is simple and can be easily done in O(n). 
We just need to check if count of the candidate element is greater than n/2.

Example :
Let the array be A[] = 2, 2, 3, 5, 2, 2, 6

Initialize maj_index = 0, count = 1
Next element is 2, which is same as a[maj_index] => count = 2
Next element is 3, which is different from a[maj_index] => count = 1
Next element is 5, which is different from a[maj_index] => count = 0
Since count = 0, change candidate for majority element to 5 => maj_index = 3, count = 1
Next element is 2, which is different from a[maj_index] => count = 0
Since count = 0, change candidate for majority element to 2 => maj_index = 4
Next element is 2, which is same as a[maj_index] => count = 2
Next element is 6, which is different from a[maj_index] => count = 1
Finally candidate for majority element is 2.
First step uses Moore’s Voting Algorithm to get a candidate for majority element.



 

2. Check if the element obtained in step 1 is majority element or not :

printMajority (a[], size)
1.  Find the candidate for majority
2.  If candidate is majority. i.e., appears more than n/2 times.
       Print the candidate
3.  Else
       Print "No Majority Element"

 *
 */
public class MajorityElement {

	public static void main(String[] args) {
		int[] inputArr = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
		int majorityElement = findMajorityElement(inputArr);
		System.out.println("majorityElement : " + majorityElement);

	}

	private static int findMajorityElement(int[] inputArr) {
		int majorityElement = -1;
		int inputArrLength = inputArr.length;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(inputArrLength);
		for (int i = 0; i < inputArrLength; ++i) {
			int element = inputArr[i];
			if (hm.containsKey(element)) {
				hm.put(element, hm.get(element) + 1);
				if (hm.get(element) > (inputArrLength / 2)) {
					majorityElement = element;
					break;
				}
			} else {
				hm.put(element, 1);
			}
		}

		return majorityElement;

	}

	public int majorityNumber(List<Integer> nums) {

		int majorityIndex = 0;
		int count = 1;

		for (int i = 0; i < nums.size(); ++i) {
			if (nums.get(majorityIndex) == nums.get(i)) {
				++count;
			} else {
				--count;
			}

			if (count == 0) {
				majorityIndex = i;
				count = 1;
			}
		}
		return nums.get(majorityIndex);
	}

}
