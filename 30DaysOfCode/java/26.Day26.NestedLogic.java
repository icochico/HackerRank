// Objective
// Today's challenge puts your understanding of nested conditional statements to the test. You already have the knowledge to complete this challenge, but check out the Tutorial tab for a video on testing!
//
// Task
// Your local library needs your help! Given the expected and actual return dates for a library book, create a program that calculates the fine (if any). The fee structure is as follows:
//
// If the book is returned on or before the expected return date, no fine will be charged (i.e.: .
// If the book is returned after the expected return day but still within the same calendar month and year as the expected return date, .
// If the book is returned after the expected return month but still within the same calendar year as the expected return date, the .
// If the book is returned after the calendar year in which it was expected, there is a fixed fine of .
// Input Format
//
// The first line contains  space-separated integers denoting the respective , , and  on which the book was actually returned.
// The second line contains  space-separated integers denoting the respective , , and  on which the book was expected to be returned (due date).
//
// Output Format
//
// Print a single integer denoting the library fine for the book received as input.
//
// Sample Input
//
// 9 6 2015
// 6 6 2015
//
// Sample Output
//
// 45

import java.io.*;
import java.util.*;
import java.time.*;
import java.time.temporal.*;


public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String returned = sc.nextLine();
        String expected = sc.nextLine();
        
        int fine = calculateFine(returned, expected);
        System.out.println(fine);
    }

    // Note: this solution uses Java 8 LocalDate
    public static int calculateFine(String returnedStr, String expectedStr) {

        String[] returnedArr = returnedStr.split(" ");
        String[] expectedArr = expectedStr.split(" ");
        LocalDate returned = LocalDate.of(Integer.valueOf(returnedArr[2]),
                                         Integer.valueOf(returnedArr[1]),
                                         Integer.valueOf(returnedArr[0]));
        LocalDate expected = LocalDate.of(Integer.valueOf(expectedArr[2]),
                                         Integer.valueOf(expectedArr[1]),
                                         Integer.valueOf(expectedArr[0]));
        long daysPassed = daysBetween(expected, returned);

        if (daysPassed < 365) {

            if (daysPassed <= 0) {
                return 0;
            }
            else if (daysPassed <= 31) {

                if (returned.getYear() == expected.getYear()) {
                    return 15 * (int) daysPassed;
                }
                else {
                    return 10000;
                }
            }
            else {
                return 500 * (int) (daysPassed / 31);
            }
        }
        else {
            return 10000;
        }
    }

    public static long daysBetween(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);

    }
}
