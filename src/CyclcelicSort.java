import java.util.Arrays;

public class CyclcelicSort {
    public static void main(String[] args) {
        
        int[] nums = {10, 2, 4, 1, 5, 9, 6, 7, 8, 3};
        cycleSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    private static void cycleSort(int[] arr) {

        int i = 0;
        while(i < arr.length) {
            if(arr[i] - 1 != i) {
                swap(arr, i, arr[i] - 1);
            }
            else
                i++;
        }

    }

    private static void swap(int[] arr, int s, int e) {

        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
}
