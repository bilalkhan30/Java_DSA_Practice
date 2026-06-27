import java.util.ArrayList;
import java.util.List;

public class NumberMissing {
    public static void main(String[] args) {
        
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(Solution.findDisappearedNumbers(arr));
    }
}

class Solution {
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        // Traverse the array and mark the values at nums[i] - 1 as negative (a flag for keeping the record that
        // the value is found) 
        for(int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }
        // Traverse the array again to find for positive values because the values at those index have'nt found
        // in the array
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;

    }
}
