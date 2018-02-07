// Objective
// Today, we're going further with Binary Search Trees. Check out the Tutorial tab for learning materials and an instructional video!
//
// Task
// A level-order traversal, also known as a breadth-first search, visits each level of a tree's nodes from left to right, top to bottom. You are given a pointer, , pointing to the root of a binary search tree. Complete the levelOrder function provided in your editor so that it prints the level-order traversal of the binary search tree.
//
// Hint: You'll find a queue helpful in completing this challenge.
//
// Input Format
//
// The locked stub code in your editor reads the following inputs and assembles them into a BST:
// The first line contains an integer,  (the number of test cases).
// The  subsequent lines each contain an integer, , denoting the value of an element that must be added to the BST.
//
// Output Format
// 
// Print the  value of each node in the tree's level-order traversal as a single line of  space-separated integers.
//
// Sample Input
//
// 6
// 3
// 5
// 4
// 7
// 2
// 1
// Sample Output
//
// 3 2 5 1 4 7
//
// Explanation
//
// We traverse each level of the tree from the root downward, and we process the nodes at each level from left to right. The resulting level-order traversal is , and we print these data values as a single line of space-separated integers.

import java.util.*;
import java.io.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}

class Solution{

  /**
  * We use a queue and add elements left to right. The StringBuilder used here is optional,
  * it's possible to use a System.out.print() to print within the same line.
  */
  static void levelOrder(Node root){
        Queue<Node> q = new ArrayDeque<Node>();
        q.clear();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Node n = q.poll();
            sb.append(n.data + " ");
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
        System.out.println(sb.toString());
      }

      public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            Node root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
            levelOrder(root);
        }
}
