public class  SearchInsertPosition {
    public static void main(String[] args) {
        
        int[] arr = {1, 3, 5, 6};
        System.out.println(searchInsert(arr, 7));
    }

    public static int searchInsert(int[] nums, int target) {

        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {

            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {

                end = mid - 1;
            } else if (target > nums[mid]) {

                start = mid + 1;
            } else {

                return mid;
            }
        }
        return start;
    }
}

