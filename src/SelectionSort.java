import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        
        int[] arr = new int[] {2, -334, 0, 234, -11};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }

    private static int[] selectionSort(int[] arr) {

        for(int i = 0; i < arr.length; i++) {

            int lastIndex = arr.length - i - 1; 
            int maxIndex = findMaxIndex(arr, 0, lastIndex);
            swap(arr, maxIndex, lastIndex);

        }
        return arr;
    }

    private static void swap(int[] arr, int maxIndex, int lastIndex) {
        int temp = arr[lastIndex];
        arr[lastIndex] = arr[maxIndex];
        arr[maxIndex] = temp;
    }

    private static int findMaxIndex(int[] arr, int start, int end) {

        int max = start;
        for(int i = start; i <= end; i++) {
            if(arr[max] < arr[i])
                max = i;
        }

        return max;
    }
}
