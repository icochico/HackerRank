// Objective
// Welcome to the last day! Today, we're discussing bitwise operations.
// Check out the Tutorial tab for learning materials and an instructional video!

// Task
// Given set S={1,2,3..N}. Find two integers, A and B (where A < B), from set S such that the value of A & B
//  is the maximum possible and also less than a given integer, K. . In this case, & represents the bitwise AND operator.

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int sets = sc.nextInt();

        for (int i = 0; i < sets; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int maxAnd = 0;
            for (int x = 1; x <= n; x++) {
                for (int y = 1; y <= n; y++) {
                    if (x == y) continue;
                    int currentAnd = (x & y);
                    if (currentAnd < k) {
                        maxAnd = Math.max(currentAnd, maxAnd);
                    }
                }
            }

            //print max bitwise and
            System.out.println(maxAnd);
        }
    }
}
