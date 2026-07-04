public class SearchinRotatedArray {
    
    public static void main(String[] args) {
        
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 2;
        int pivot = findPivot(nums);
        if (pivot == -1)
            System.out.println("target is at index: "+binarySearch(nums, 0, nums.length - 1, target)); 
        else if (nums[pivot] == target)
            System.out.println("target is at index: "+pivot);
        else if (target >= nums[0])
            System.out.println("target is at index: "+binarySearch(nums, 0, pivot - 1, target));
        else if (target < nums[0])
            System.out.println("target is at index: "+binarySearch(nums, pivot + 1, nums.length - 1, target));
        else
            System.out.println("target is not in the array,");
        
    }

    public static int findPivot(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;

            if(nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            }
            else if(mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            else if(mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                return mid - 1;
            }
            else if(nums[start] >= nums[mid]) {
                end = mid - 1;
            }
            else if(nums[start] < nums[mid]) {
                start = mid + 1;
            }
        }
        return -1;  
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(target < nums[mid])
                end = mid - 1;
            else if(target > nums[mid])
                start = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
