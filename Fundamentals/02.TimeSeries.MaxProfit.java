import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.

 Suppose we could access yesterday's stock prices as a list, where:
The indices are the time in minutes past trade opening time, which was 9:30am local time.
The values are the price in dollars of Apple stock at that time.
So if the stock cost $500 at 10:30am, stock_prices_yesterday[60] = 500.
Write an efficient function that takes stock_prices_yesterday and returns the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.
For example:
  stock_prices_yesterday = [10, 7, 5, 8, 11, 9]
  get_max_profit(stock_prices_yesterday)
  # returns 6 (buying for $5 and selling for $11)
No "shorting"—you must buy before you sell.

 */

class Solution {


  // To accomplish this, suppose that we keep track of the minimum value in the
  // first k elements, along with the maximum profit we could make in the first
  // k elements.  Upon seeing the (k + 1)st element, we update what the current
  // minimum value is, then update what the maximum profit we can make is by
  // seeing whether the difference between the (k + 1)st element and the new
  // minimum value is.  Note that it doesn't matter what order we do this in; if
  // the (k + 1)st element is the smallest element so far, there's no possible way
  // that we could increase our profit by selling at that point.

  // To finish up this algorithm, we should note that given just the first price,
  // the maximum possible profit is 0.

  // This gives the following simple and elegant algorithm for the maximum single-
  // sell profit problem:

  // Let profit = 0.
  // Let min = arr[0]
  // For k = 1 to length(arr):
  //    If arr[k] < min, set min = arr[k]
  // If profit < arr[k] - min, set profit = arr[k] - min
  public static int getMaxProfit(int[] stockValue) {

    int maxProfit = 0;
    int localMin = Integer.MAX_VALUE;
    int localMax = 0;
    for (int i = 0; i < stockValue.length; i++) {

      // Update the minimum value to be the lower of the existing minimum and
      // the new minimum.
      localMin = Math.min(localMin, stockValue[i]);

      // Update the maximum profit to be the larger of the old profit and the
      // profit made by buying at the lowest value and selling at the current
      // price.
      if (stockValue[i] > localMax) {
          localMax = stockValue[i];
          maxProfit = localMax - localMin;
      }
    }

    return maxProfit;
  }

  public static void main(String[] args) {

    int[] sample = {20, 1, 4, 25, 70, 101, 5};
    int maxProfit = getMaxProfit(sample);
    System.out.println("Max profit is: " + maxProfit);

  }
}
