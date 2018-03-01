// Check out the resources on the page's right side to learn more about hashing. The video tutorial is by Gayle Laakmann McDowell, author of the best-selling interview book Cracking the Coding Interview.
// A kidnapper wrote a ransom note but is worried it will be traced back to him. He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note. The words in his note are case-sensitive and he must use whole words available in the magazine, meaning he cannot use substrings or concatenation to create the words he needs.
//
// Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.
//
// Output Format
//
// Print Yes if he can use the magazine to create an untraceable replica of his ransom note; otherwise, print No.
//
// Sample Input 0
//
// 6 4
// give me one grand today night
// give one grand today
// Sample Output 0
//
// Yes
// Sample Input 1
//
// 6 5
// two times three is not four
// two times two is four
// Sample Output 1
//
// No

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }

        isRansomNoteViable(magazine, ransom);
    }

    public static void isRansomNoteViable(String[] magazine, String[] ransom) {

        // Create and fill the dictionary, keeping count of how many words of each kind.
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < magazine.length; i++) {
           if (dictionary.get(magazine[i]) == null) {
               dictionary.put(magazine[i], 1);
           }
           else {
               int count = dictionary.get(magazine[i]);
               count++;
               dictionary.put(magazine[i], count);
           }
        }

        // Iterate through hypothetical ransom words, decreasing the count of each word in the dictionary being matched.
        // At the first word not found, print "No" and return. If for loops reaches the end, print "Yes".
        for (int i = 0; i < ransom.length; i++) {
            if (dictionary.get(ransom[i]) != null) {
               int count = dictionary.get(ransom[i]);
               count--;
               if (count == 0) {
                   dictionary.remove(ransom[i]);
               }
               else {
                   dictionary.put(ransom[i], count);
               }
            }
            else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
