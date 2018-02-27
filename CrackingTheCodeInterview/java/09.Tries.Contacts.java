// We're going to make our own Contacts application! The application must perform two types of operations:
//
// 1. add name, where name is a string denoting a contact name. This must store name as a new contact in the application.
// 2. find partial, where partial is a string denoting a partial name to search the application for.
//    It must count the number of contacts starting with partial and print the count on a new line.
// Given n sequential add and find operations, perform each operation in order.
//
// Input Format
//
// The first line contains a single integer, n, denoting the number of operations to perform.
// Each line i of the n subsequent lines contains an operation in one of the two forms defined above.
// Output Format
//
// For each find partial operation, print the number of contact names starting with  on a new line.
//
// Sample Input
//
// 4
// add hack
// add hackerrank
// find hac
// find hak
// Sample Output
//
// 2
// 0
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static class TrieNode {
        HashMap<Character, TrieNode> children;
        int size;

        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            size = 0;
        }
    }

    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // 1. Set a current node as a root node
        // 2. Set the current letter as the first letter of the word
        // 3. If the current node has already an existing reference to the current letter (through one of the elements in the     //    “children” field), then set current node to that referenced node. Otherwise, create a new node, set the letter       //    equal to the current letter, and also initialize current node to this new node
        // 4. Repeat step 3 until the key is traversed
        public void add(String word) {

            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                current = current.children.computeIfAbsent(word.charAt(i), c -> new TrieNode());
                current.size++;
            }
        }

        // 1. Get children of the root
        // 2. Iterate through each character of the String
        // 3. Check whether that character is already a part of a sub-trie. If it isn’t present anywhere in the trie, then               stop the search and return 0 as the number of occurrences
        // 4. Repeat the second and the third step until there isn’t any character left in the String.
        //    If the end of the String is reached, return the size (how many occurrences)
        public int findPartial(String prefix) {
            TrieNode current = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                TrieNode node = current.children.get(ch);
                if (node == null) {
                    return 0;
                }
                current = node;
            }

            return current.size;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Trie t = new Trie();


        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();

            if (op.equals("add")) {
                t.add(contact);
            }
            else {
                 System.out.println(t.findPartial(contact));
            }
         }
    }
}
