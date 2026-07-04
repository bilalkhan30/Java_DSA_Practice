public class SearchinRotatedArray_II {
    
    public static void main(String[] args) {
        
        int[] nums = {1, 1, 1, 1, 2, 1, 1, 1};
        System.out.println("targte is at index: "+binarySearch(nums, 2));
    }

    public static int binarySearch(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;

            if(nums[mid] == target) {
                return mid;
            }
            // Removing the ambiguity
            else if(nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            }
            // Left half of the array
            else if(nums[start] <= nums[mid]) {

                if(nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            // Right half of the array
            else {

                if(nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
