// Consider a matrix with n rows and m columns, where each cell contains either a 0 or a 1
// a  and any cell containing a 1 is called a filled cell.
// Two cells are said to be connected if they are adjacent to each other
// horizontally, vertically, or diagonally;
// If one or more filled cells are also connected, they form a region.
// Note that each cell in a region is connected to at least one other cell in the
// region but is not necessarily directly connected to all the other cells in the
// region.

// Task
// Given an n x m matrix, find and print the number of cells in the largest region in the
// matrix. Note that there may be more than one region in the matrix.
//
// Input Format
//
// The first line contains an integer, n, denoting the number of rows in the matrix.
// The second line contains an integer, m, denoting the number of columns in the matrix.
// Each line i of the n subsequent lines contains m space-separated integers describing
// the respective values filling each row in the matrix.

// Example
//
// Sample Input
//
// 4
// 4
// 1 1 0 0
// 0 1 1 0
// 0 0 1 0
// 1 0 0 0
// Sample Output
//
// 5
//
// Explanation
//
// The diagram below depicts two regions of the matrix; for each region, the
// component cells forming the region are marked with an X:
//
// X X 0 0     1 1 0 0
// 0 X X 0     0 1 1 0
// 0 0 X 0     0 0 1 0
// 1 0 0 0     X 0 0 0

// The first region has five cells and the second region has one cell.
// Because we want to print the number of cells in the largest region of
// the matrix, we print 5.

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

   public static int getBiggestRegion(int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, countCells(matrix, i, j));
            }
        }
        return max;
    }

    private static int countCells(int[][] matrix, int i, int j) {
        // if cell doesn't exist, return
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) return 0;
        // if already counted or 0, return
        if (matrix[i][j] == 0) return 0;
        // otherwise, count
        int count = 1;
        // This as a flag to stop the recursion.
        // The position (i,j) won't be counted more than once because the code
        // only cares about positions with 1's
        matrix[i][j] = 0;

        // we recursively execute on the cells that are connected to the current
        count += countCells(matrix, i + 1, j);
        count += countCells(matrix, i - 1, j);
        count += countCells(matrix, i, j + 1);
        count += countCells(matrix, i, j - 1);
        count += countCells(matrix, i + 1, j + 1);
        count += countCells(matrix, i - 1, j - 1);
        count += countCells(matrix, i - 1, j + 1);
        count += countCells(matrix, i + 1, j - 1);
        return count;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }

        int biggestRegion = getBiggestRegion(grid);
        System.out.println(biggestRegion);
    }
}
