import java.util.*; 


class Solution {

    // In this case, we first append the two unsorted arrays. Then we simply sort the concatenated array.
    //
    // Time Complexity O((n + m)*(log(n+m)))
    // Space O(n + m)
    public static int[] mergeAndSort(int a[], int b[]) {

        int n = a.length;
        int m = b.length;
        int result[] = new int[n + m];
        int i = 0, j = 0, k = 0;
        // merge a into result
        while (i < n) {
            result[k] = a[i];
            i++;
            k++;
        }

        // merge b into result
        while (j < m) {
            result[k] = b[j];
            j++;
            k++;
        }

        // sort the result
        Arrays.sort(result);

        return result;
    }

    // We first sort both the given arrays separately. Then we simply merge two sorted arrays.
    // (this method is better than the first one)
    //
    // Time Complexity O(nlongn + mlongm + (n+m))
    // Space Complexity O((n+m))
    public static int[] sortAndMerge(int a[], int b[]) {

        int n = a.length;
        int m = b.length;
        int result[] = new int[n + m]; 
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            // check which one is lesser and increment appropriate indexes
            if (a[i] <= b[j]) {
                result[k] = a[i];
                i++;
                k++;
            }
            else {
                result[k] = b[j];
                j++;
                k++;
            }
        }

        // merge remaining elements of a[] (if any)
        while (i < n) {
            result[k] = a[i];
            i++;
            k++;
        }

        // merge remaining elements of b[] (if any)
        while (j < m) {
            result[k] = b[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args)
    {
        int a[] = { 10, 5, 15 };
        int b[] = { 20, 3, 2, 12 };

        int result[] = sortAndMerge(a, b);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + " ");
        }
    }
}




