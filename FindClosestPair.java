/*
 * Find the pair whose sum is closest to a number in a sorted array
 * If you need more classes, simply define them inline.
 * Input: arr[] = {10, 22, 28, 29, 30, 40}, x = 54
 * Output: 22 and 30
 * Input: arr[] = {1, 3, 4, 7, 10}, x = 15
 * Output: 4 and 10
 */
class Solution {
  
  public static void findClosest(int[] arr, int x) {
  
    int n = arr.length;
    int difference = Integer.MAX_VALUE;
    int left = 0;
    int right = n -1;
    
    int result_left = 0, result_right = 0;
    
    while (right > left) {
      
      int sum = arr[left] + arr[right];
      
      if (Math.abs(sum - x) < difference) {
        
        result_left = left;
        result_right = right;
        
        difference = Math.abs(sum - x);
      }
      
      if (sum > x) {
        right--;
      }
      else {
        left++;
      }
    }
    
    System.out.println("Closest pair is: " + arr[result_left] + ", " + arr[result_right]);
  }
  
  
  public static void main(String[] args) {
    
      int arra[] = {10, 22, 28, 29, 30, 40};
      int x = 54;
    
      int arrb[] = {1, 3, 4, 7, 10};
      int y = 15;
    
      findClosest(arrb, y);
  }
}