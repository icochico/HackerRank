// Print two space-separated integers denoting the respective ID numbers for the two distinct flavors they choose to purchase, 
// where the smaller ID is printed first and the larger ID is printed second. 
// Recall that each ice cream flavor has a unique ID number in the inclusive range from 1 to flavors.

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    // While we iterate and inserting elements into the table, 
    // we also look back to check if current element's complement already exists in the table. 
    // If it exists, we have found a solution and return immediately.
    // Time complexity : O(n). We traverse the list containing nn elements only once. 
    // Each look up in the table costs only O(1) time.
    // Space complexity : O(n). 
    // The extra space required depends on the number of items stored in the hash table, 
    // which stores at most n elements.
    static void twoSum(int[] nums, int money) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = money - nums[i];
            if (map.containsKey(complement)) {
                System.out.println((map.get(complement) + 1) + " " + (i + 1)); //because flavors start with 1
            }
            map.put(nums[i], i);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int money = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            twoSum(arr, money);
        }
        in.close();
    }
}
