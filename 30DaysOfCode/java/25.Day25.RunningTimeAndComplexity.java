// Objective
// Today we're learning about running time! Check out the Tutorial tab for learning materials and an instructional video!
//
// Task
// A prime is a natural number greater than  that has no positive divisors other than  and itself. Given a number, , determine and print whether it's  or .
//
// Note: If possible, try to come up with a  primality algorithm, or see what sort of optimizations you come up with for an  algorithm. Be sure to check out the Editorial after submitting your code!
//
// Input Format
//
// The first line contains an integer, , the number of test cases.
// Each of the  subsequent lines contains an integer, , to be tested for primality.
//
// Output Format
//
// For each test case, print whether  is  or  on a new line.
//
// Sample Input
//
// 3
// 12
// 5
// 7
// Sample Output
//
// Not prime
// Prime
// Prime

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        while (tests-- > 0) {
            int number = sc.nextInt();

            if (isPrime(number)) {
                System.out.println("Prime");
            }
            else {
                System.out.println("Not prime");
            }


        }
    }

    public static boolean isPrime(int n) {

        if (n == 1) return false; //1 is not prime
        if (n == 2) return true;  //2 is prime
        if (n % 2 == 0) return false; //all the others numbers that have 2 has divisor are not prime

        int cap = (int) (Math.sqrt(n));
        // We know 2 is the "oddest" prime - it happens to be the only even prime number.
        // Because of this, we need only to check 2 separately,
        // then traverse odd numbers up to the square root of n
        for (int i = 3; i <= cap; i += 2) {
            if (n % i == 0) return false;
        }

        return true;
    }

}
