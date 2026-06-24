import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        
        int[] arr1 = {5, 1, 5, 6, 3, 4, 8, 1, 9, 0};
        int[] arr2 = {5, 1, 5, 6, 3, 4, 8, 1, 9, 0};
        int[] arr3 = {5, 1, 5, 6, 3, 4, 8, 1, 9, 0};
        selectionSort(arr1);
        insertionSort(arr2);
        bubbleSort(arr3);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));

    }

    private static void bubbleSort(int[] arr) {
        int length = arr.length;
        boolean isSwapped;
        for (int i = 0; i < length; i++) {
            isSwapped = false;
            for (int j = 1; j < length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }

    }

    private static void insertionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            while (j != 0) {
                if (arr[j] <= arr[j - 1]) {
                    swap(arr, j, j - 1);
                    j--;
                } else
                    break;
            }
        }
    }

    private static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int lastIndex = arr.length - i - 1;
            int maxIndex = findMaxIndex(arr, 0, lastIndex);
            swap(arr, maxIndex, lastIndex);

        }
    }

    private static void swap(int[] arr, int maxIndex, int lastIndex) {
        int temp = arr[lastIndex];
        arr[lastIndex] = arr[maxIndex];
        arr[maxIndex] = temp;
    }

    private static int findMaxIndex(int[] arr, int start, int end) {

        int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i])
                max = i;
        }

        return max;
    }


}
