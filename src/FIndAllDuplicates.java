import java.util.ArrayList;
import java.util.List;

public class FIndAllDuplicates {
    public static void main(String[] args) {
        
        int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(arr));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] < 0) {
                res.add(num);
            }
            nums[num - 1] *= -1;
        }
        return res;

    }
}
