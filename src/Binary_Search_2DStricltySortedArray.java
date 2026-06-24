import java.util.Arrays;

public interface Binary_Search_2DStricltySortedArray {
    public static void main(String[] args) {
        int[][] arr = {

            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.print(Arrays.toString(search(arr, 99)));
    }

    public static int[] search(int[][] arr, int target) {

        int rows = arr.length;
        int cols = arr[0].length;
        // Empty matrix
        if(cols == 0) {               
            return new int[] {-1, -1};
        }
        // 1D array
        if(rows == 1) {              
            return binarySearch(arr, rows, 0, cols - 1, target);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols/2;
        // While the matrix has more than 2 Rows, minimize the search space.
        while(rStart < (rEnd - 1)) {  
            int rMid = rStart + (rEnd - rStart)/2;
            if(arr[rMid][cMid] == target) {
                return new int[] {rMid, cMid};
            }
            if(arr[rMid][cMid] > target) {
                rEnd = rMid;
            } else {
                rStart = rMid;
            }
        }

        // Now after the While loop, we have 2 rows remaining.
        if(arr[rStart][cMid] == target) {
            return new int[] {rStart, cMid};
        }
        if(arr[rStart + 1][cMid] == target) {
            return new int[] {rStart + 1, cMid};
        }
        if(target <= arr[rStart][cMid - 1]) {
            return binarySearch(arr, rStart, 0, cMid - 1, target);
        }
        if(target >= arr[rStart][cMid + 1] && target <= arr[rStart][cols - 1]) {
            return binarySearch(arr, rStart, cMid + 1, cols - 1, target);
        }
        if(target <= arr[rStart + 1][cMid - 1]) {
            return binarySearch(arr, rStart + 1, 0, cMid - 1, target);
        }
        if(target >= arr[rStart + 1][cMid + 1] && target <= arr[rStart + 1][cols - 1]) {
            return binarySearch(arr, rStart + 1, cMid + 1, cols - 1, target);
        }
        return new int[] {-1, -1};
    }

    public static int[] binarySearch(int[][] arr, int row, int cStart, int cEnd, int target) {
        while(cStart <= cEnd) {
            int cMid = cStart + (cEnd - cStart)/2;
            if(arr[row][cMid] == target) {
                return new int[] {row, cMid};
            }
            if(arr[row][cMid] < target) {
                cStart = cMid + 1;
            } else {
                cEnd = cMid - 1;
            }
        }

        return new int[] {-1, -1};
    }
}
