import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        
        int[] arr = {5, 3, 2, 5, 5, 4, 3, 1, 1, 5};
        insertionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr, int size) {

        for (int i = 0; i < size - 1; i++) {
            int j = i + 1;
            while(j != 0) {
                if(arr[j] <= arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    j--;
                }
                else
                    break;
            }
        }
    } 
}
