// Find if a given String is an anagram of a palindrome
// Complete the gameOfThrones function below to determine whether a given string can 
// be rearranged into a palindrome. If it is possible, return YES, otherwise return NO.
// e.g. 
// Input: aaabbbb
// Output: YES
// (A palindromic permutation of the given string is bbaaabb.)
// 
// Input: cdefghmnopqrstuvw
// Output: NO
// (Palindromes longer than 1 character are made up of pairs of characters. There are none here.)
//
// Input: cdcdcdcdeeeef
// Output: YES
// (An example palindrome from the string: ddcceefeeccdd.)

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Arrays;


public class Solution {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {

        // if length is 1, is palindrome
        if (s.length() == 1) {
            return "YES";
        }

        // count characters 
        final Map<Character, Integer> counter = new HashMap<>();
        // count
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Character ch = Character.valueOf(c);

            if (counter.get(ch) == null) {
                counter.put(ch, 1);
            }
            else {
                int count = counter.get(ch);
                count++;
                counter.put(ch, count);
            }
        }

        boolean foundOdd = false;
        // check if pair matching
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            Character ch = entry.getKey();
            int count = entry.getValue();

            // check if even
            if (!(count % 2 == 0)) {
                if (!foundOdd) {
                    foundOdd = true;
                }
                else {
                    // if more than one character count is odd, can't be palindrome
                    return "NO";
                }
            }
        }
            
        return "YES"; 
    }


    static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}