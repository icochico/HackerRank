// Consider the following version of Bubble Sort:
//
// for (int i = 0; i < n; i++) {
//
//     for (int j = 0; j < n - 1; j++) {
//         // Swap adjacent elements if they are in decreasing order
//         if (a[j] > a[j + 1]) {
//             swap(a[j], a[j + 1]);
//         }
//     }
//
// }
// Task
// Given an n-element array,of distinct elements, sort array in ascending order using the Bubble Sort algorithm above. Once sorted, print the following three lines:
//
// Array is sorted in numSwaps swaps., where numSwaps is the number of swaps that took place.
// First Element: firstElement, where firstElement is the first element in the sorted array.
// Last Element: lastElement, where lastElement  is the last element in the sorted array.
// Hint: To complete this challenge, you must add a variable that keeps a running tally of all swaps that occur during execution.
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


    static class Array {

        private int[] array;
        private int length;

        Array(int[] buffer) {
            array = buffer;
            length = buffer.length;
        }

         //@return the number of swaps
        int bubbleSort() {
            int countSwaps = 0;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        swap(j, j + 1);
                        countSwaps++;
                    }
                }
            }

            return countSwaps;
        }

        int getFirst() {
            if (length > 1) {
                return array[0];
            }
            else {
                throw new RuntimeException("Array is empty");
            }
        }

        int getLast() {
            if (length > 1) {
                return array[length - 1];
            }
            else {
                throw new RuntimeException("Array is empty");
            }
        }

        void swap(int a, int b) {
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        Array array = new Array(a);
        int swaps = array.bubbleSort();
        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + array.getFirst());
        System.out.println("Last Element: " + array.getLast());
    }
}
