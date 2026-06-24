import java.util.Arrays;

public class Binary_Search_2DSortedArrays {
    public static void main(String[] args) {
        
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] result = binarySearch2Darr(arr, 10);
        System.out.print(Arrays.toString(result));
    }

    static int[] binarySearch2Darr(int[][] arr, int target) {

        int row = 0;
        int col = arr[0].length - 1;

        while(row < arr.length && col >= 0) {

            if(arr[row][col] == target)
                return new int[] {row,col};
            else if(arr[row][col] > target) // Eliminate column
                col--;
            else                            // Eliminate row
                row++;
        }
        return new int[] {-1,-1};
    }
}
