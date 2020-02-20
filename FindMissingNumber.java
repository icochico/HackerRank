
// Find the only missing number in a sorted array and return it. 
// If no number is missing, return -1
// 
// # Input :ar[] = {2, 4, 5, 6}
// # Output : 3

// # Input : ar[] = {1, 2, 3, 4, 5, 7, 8}
// # Output : 6


class Solution {

    // Brute force solution
    // Cost O(n)
    public static int findMissingNumber(int[] array) {

        int element = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                element = array[i];
            }
            else {
                element++;
                if (element != array[i]) {
                    return element;
                }
            }
        }

        return -1;
    }



    public static void main(String[] args) {

        int[] array = {2, 4, 5, 6};

        int result = findMissingNumber(array);
        System.out.println("Missing number is: " + result);
    }
}