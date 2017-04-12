/*
329. Longest Increasing Path in a Matrix
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. 
You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:
nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:
nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 1;
        int length = 0;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
               length = dfs(matrix, cache, i, j);
               //max here is the longest increasing path in the whole matrix
               max = Math.max(max, length);
            }
        }
        return max;
    }
    
    private int dfs(int[][] matrix, int[][] cache, int i, int j){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
         //cache is marked 
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int max = 1;
        //cache is not marked
        for(int k = 0; k < 4; k++){
           //step from cur node itself
           //whether the node can move to other directions or not, self step is 1
           //int max = 1;
           int x = i + dx[k];
           int y = j + dy[k];
           //boundary check && move towards larger number 
           if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]){
               continue;
           }
           //len : to the single direction, the increasing path can be
           int len = 1 + dfs(matrix, cache, x, y);
           //max: to the four directions, the max increasing path can be 
           max = Math.max(max, len);
        }
        //mark cache
        cache[i][j] = max;
        return max;
    }
}
