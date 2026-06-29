public class FindDuplicateNumber {
    
    public static void main(String[] args) {
        
        int[] arr = { 1, 3, 4, 2, 2};
        System.out.println(findDuplicate(arr));

    }

    public static int findDuplicate(int[] nums) {

        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if(nums[num - 1] < 0)
                return num;
            nums[num - 1] *= -1;
        }
        return -1;
    }
}


