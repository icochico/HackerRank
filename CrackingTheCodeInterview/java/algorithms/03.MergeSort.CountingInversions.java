// Given d datasets, print the number of inversions that must be swapped to sort each dataset on a new line.
// Output Format
//
// For each of the  datasets, print the number of inversions that must be swapped to sort the dataset on a new line.
//
// Sample Input
//
// 2
// 5
// 1 1 1 2 2
// 5
// 2 1 3 1 2
// Sample Output
//
// 0
// 4

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    // We can avoid allocating and copying multiple arrays
    // by using a single aux array of size n (where n is the size of the original array).
    // Both arrays are switched on each recursive call.
    static long countInversions(int[] arr) {
        int[] aux = arr.clone();
        return mergeSort(arr, 0, arr.length - 1, aux);
    }

     // Explanation:
     //
     // 1. Find the middle point to divide the array into two halves:
     //         middle m = (l+r)/2
     // 2. Call mergeSort for first half:
     //         Call mergeSort(arr, l, m)
     // 3. Call mergeSort for second half:
     //         Call mergeSort(arr, m+1, r)
     // 4. Merge the two halves sorted in step 2 and 3:
     //         Call merge(arr, l, m, r)
    private static long mergeSort (int[] arr, int lo, int hi, int[] aux) {
                if (lo >= hi) return 0;
        int mid = lo + (hi - lo) / 2;

        long count = 0;

        // Swapping the original and the aux array saves you an extra "copying" step each time you make a merge
        count += mergeSort(aux, lo, mid, arr); // left inversions
        count += mergeSort(aux, mid + 1, hi, arr); // right inversions
        count += merge(arr, lo, mid, hi, aux); // split inversions

        return count;
    }


    private static long merge(int[] arr, int lo, int mid, int hi, int[] aux) {
        long count = 0;
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid || j <= hi) {
            if (i > mid) {
                arr[k++] = aux[j++];
            } else if (j > hi) {
                arr[k++] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = aux[j++];

                // Consider following case for split inversion : 1 3 5 6 | 2 4 7
                // These two are sorted sub-arrays. When you merge them 1 will need no inversions
                // but 2 will have to invert all of 3 5 6 to reach to its appropriate place
                count += mid + 1 - i;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            long result = countInversions(arr);
            System.out.println(result);
        }
        in.close();
    }
}
