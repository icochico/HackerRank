// Objective
// Today, we're working with regular expressions. Check out the Tutorial tab for learning materials and an instructional video!
//
// Task
// Consider a database table, Emails, which has the attributes First Name and Email ID. Given  rows of data simulating the Emails table, print an alphabetically-ordered list of people whose email address ends in .
//
// Input Format
//
// The first line contains an integer, , total number of rows in the table.
// Each of the  subsequent lines contains  space-separated strings denoting a person's first name and email ID, respectively.
//
// Constraints
//
// Each of the first names consists of lower case letters [a-z] only.
// Each of the email IDs consists of lower case letters [a-z], @  and . only.
// The length of the first name is no longer than 20.
// The length of the email ID is no longer than 50.
// Output Format
//
// Print an alphabetically-ordered list of first names for every user with a gmail account. Each name must be printed on a new line.
//
// Sample Input
//
// 6
// riya riya@gmail.com
// julia julia@julia.me
// julia sjulia@gmail.com
// julia julia@gmail.com
// samantha samantha@gmail.com
// tanya tanya@gmail.com
// Sample Output
//
// julia
// julia
// riya
// samantha
// tanya
import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();

        // Could have just used if (email.contains("@gmail.com")) { } but for the purpose of this exercise
        // We'll use RegEx
        String regex = "[a-z]+@gmail\\.com$";

        // Using Collections.sort(list, String.CASE_INSENSITIVE_ORDER)
        // Could have used a TreeSet (new TreeSet<String>(Collator.getInstance())
        // A TreeSet is  sorted collection of Strings without duplicates, it stays true at every moment, but
        // here we can have duplicates
        List<String> gmailUsers = new ArrayList<String>();
        for (int i = 0; i < rows; i++) {
               String firstName = sc.next();
               String email = sc.next();
               Pattern p = Pattern.compile(regex);
               Matcher matcher = p.matcher(email);
               if (matcher.find()) {
                   gmailUsers.add(firstName);
               }
        }
        // Sort
        Collections.sort(gmailUsers, String.CASE_INSENSITIVE_ORDER);

        // Print result
        for (String firstName : gmailUsers) {
            System.out.println(firstName);
        }
    }
}
