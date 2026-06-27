public class CountNegativesinSortedArray {
    public static void main(String[] args) {
        
        int[][] grid = {{3,2},{1,0}};
        System.out.println(Solution.countNegatives(grid));
    }
}

class Solution {
    public static int countNegatives(int[][] grid) {
        
        int row = 0;
        int col = grid[0].length - 1;
        int count = 0;
        while(row < grid.length && col >= 0) {

            if(grid[row][col] < 0) {
                count += grid.length - row;
                col--;
            }
            else {

                row++;
            }
        }
        return count;
    }
}
