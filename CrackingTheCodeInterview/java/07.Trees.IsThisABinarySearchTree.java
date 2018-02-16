// For the purposes of this challenge, we define a binary search tree to be a binary tree with the following ordering properties:
//
// The  data value of every node in a node's left subtree is less than the data value of that node.
// The  data value of every node in a node's right subtree is greater than the data value of that node.
// Given the root node of a binary tree, can you determine if it's also a binary search tree?
//
// Complete the function in your editor below, which has  parameter: a pointer to the root of a binary tree. It must return a boolean denoting whether or not the binary tree is a binary search tree. You may have to write one or more helper functions to complete this challenge.
//
// Note: We do not consider a binary tree to be a binary search tree if it contains duplicate values.


/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
boolean checkBST(Node root) {
    return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

/**
* The recursive call makes sure that subtree nodes are within the range of its ancestors.
* The running time complexity will be O(n) since every node is examined once.
*/
boolean isValidBST(Node node, int low, int high) {

    if (node == null) return true;

    boolean valid = node.data > low
                 && node.data < high
                 && isValidBST(node.left, low, node.data) //left substree
                 && isValidBST(node.right, node.data, high); //right substree

    //System.out.println("Valid: " + valid + " low < " + low + " [" + node.data + "] " + high + " > high");

    return valid;
}
