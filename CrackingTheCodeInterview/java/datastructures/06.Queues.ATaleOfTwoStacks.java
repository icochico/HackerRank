// A queue is an abstract data type that maintains the order in which elements were added to it, allowing the oldest elements to be removed from the front and new elements to be added to the rear. This is called a First-In-First-Out (FIFO) data structure because the first element added to the queue (i.e., the one that has been waiting the longest) is always the first one to be removed.
//
// A basic queue has the following operations:
//
// Enqueue: add a new element to the end of the queue.
// Dequeue: remove the element from the front of the queue and return it.
// In this challenge, you must first implement a queue using two stacks. Then process  queries, where each query is one of the following  types:
//
// 1 x: Enqueue element  into the end of the queue.
// 2: Dequeue the element at the front of the queue.
// 3: Print the element at the front of the queue.

// Sample Input
//
// 10
// 1 42
// 2
// 1 14
// 3
// 1 28
// 3
// 1 60
// 1 78
// 2
// 2
// Sample Output
//
// 14
// 14

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /*
     *  Using this method, each element will be in each stack exactly once - meaning each element will be pushed twice and      *  popped twice, giving amortized constant time operations.
     */
    static class MyQueue<T> {

        Stack<T> lifo = new Stack<T>();
        Stack<T> fifo = new Stack<T>();

        public void enqueue(T value) {

            // push element in our LIFO stack
            lifo.push(value);
        }

        public T dequeue() {

            refill();

            // pop first element from our FIFO stack
            return fifo.pop();
        }

        public T peek() {

            refill();

            // peek first element from our FIFO stack
            return fifo.peek();
        }

        void refill() {

            // if FIFO is empty, refill by popping each element from LIFO and pushing into FIFO
            if (fifo.isEmpty()) {
                while (!lifo.isEmpty()) {
                    T element = lifo.pop();
                    fifo.push(element);
                }
            }
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
