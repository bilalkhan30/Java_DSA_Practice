import java.util.Arrays;

public class SetMIssMatch {
    public static void main(String[] args) {
        
        int[] arr = {1, 1};
        System.out.println(Arrays.toString(findErrorNums(arr)));
    }

    public static int[] findErrorNums(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[2];
        int i = 0;
        while(i < n) {
            if(nums[i] == i + 1) {
                i++;
            }
            else if(nums[i] == nums[nums[i] -1]) {
                res[0] = nums[i];
                i++;
            }
            else {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for(i= 0; i < n; i++) {
            if(nums[i] != i + 1)
                res[1] = i + 1; 
        }
        return res;
    }
}
