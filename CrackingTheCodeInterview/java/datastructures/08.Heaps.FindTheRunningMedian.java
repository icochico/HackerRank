// The median of a dataset of integers is the midpoint value of the dataset for
// which an equal number of integers are less than and greater than the value.
// To find the median, you must first sort your dataset of integers in non-decreasing order, then:

// If your dataset contains an odd number of elements,
// the median is the middle element of the sorted sample.
// In the sorted dataset {1, 2, 3}, 2 is the median.

// If your dataset contains an even number of elements, the median is the
// average of the two middle elements of the sorted sample.
// In the sorted dataset {1, 2, 3, 4}, 2 + 3 / 2 = 2.5 is the median.

// Sample Input
//
// 6
// 12
// 4
// 5
// 3
// 8
// 7

// Sample Output
//
// 12.0
// 8.0
// 5.0
// 4.5
// 5.0
// 6.0

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        DoubleHeap doubleHeap = new DoubleHeap();
        for(int a_i=0; a_i < n; a_i++){
            doubleHeap.add(in.nextInt());
            System.out.println(doubleHeap.median());

        }
    }

// minHeap will contain the maximum half of the numbers from the array. (high)
// maxHeap will contain the minimum half of the numbers from the array. (low)

// The top value from the minHeap will be the minimum number from the max half of the array. (high)
// The top value from the maxHeap will be the maximum number from the min half of the array. (low)

// In maxHeap we need to put all the items which are less than items in the Min-heap.
// Example:
// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10

// In this sequence 1, 2, 3, 4, 5 should be part of maxHeap (low)
// And, 6, 7, 8, 9, 10 shoul de part of minHeap. (high)

// So that every time we can pick median in one operation:-

// high.peek() -> will give 6
// low.peek() -> will give 5
    static class DoubleHeap {

        private Queue<Integer> low = new PriorityQueue<>(Comparator.reverseOrder());
        private Queue<Integer> high = new PriorityQueue<>();

        public void add(int number) {
            // fill the smallest queue to keep the queues equal
            Queue<Integer> target = low.size() <= high.size() ? low : high;
            target.add(number);
            balance();
        }

        private void balance() {
            // if unbalanced, exchange the highest and the lowest among queues
            if (!low.isEmpty() && !high.isEmpty() && low.peek() > high.peek()) {
                Integer lowHead = low.poll();
                Integer highHead = high.poll();
                low.add(highHead);
                high.add(lowHead);
            }
        }

        public double median() {
            if(low.isEmpty() && high.isEmpty()) {
                throw new IllegalStateException("Heap is empty");
            } else {

                if (low.size() == high.size()) {
                    return (low.peek() + high.peek()) / 2.0; //even number of items
                }
                else {
                    return low.peek();
                    //odd number of items
                    //low will be the highest sized queue if the two queues were even at the previous add
                }
            }
        }
    }
}
