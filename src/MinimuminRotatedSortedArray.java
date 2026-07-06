public class MinimuminRotatedSortedArray {
    
    public static void main(String[] args) {
        
        int[] arr = {11, 13, 15, 17};
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] nums) {

        // find pivot element in rotated array which is the largest
        // if pivot element is not found (i.e pivot == -1) then it means that array wasn't rotated. Hence return first element
        // if pivot is found then next element to the pivot is the minimum element in th e array
        int pivot = findPivot(nums); 
        if(pivot == -1) {
            return nums[0];
        }
        else {
            return nums[pivot + 1];
        }
    }

    public static int findPivot(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(mid + 1 < nums.length && nums[mid] > nums[mid + 1])
                return mid;
            else if(mid - 1 >= 0 && nums[mid - 1] > nums[mid])
                return mid - 1;
            else if(nums[start] >= nums[mid])
                end = mid - 1;
            else if(nums[start] < nums[mid])
                start = mid + 1;
        }
        return -1;
    }
}
