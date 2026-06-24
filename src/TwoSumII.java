import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        
        int[] nums = {3, 24, 50, 79, 88, 150, 345};
        System.out.println(Arrays.toString(Solution.twoSum(nums, 200)));
    }
}

class Solution {
    public static int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while(numbers[left] + numbers[right] != target) {

            if(numbers[left] + numbers[right] > target) {  // Sum is large then decrease right pointer to include a smaller value
                right--;
            }
            else {
                left++;  // Sum is small then increament the left pointer to include bigger value
            }
        }

        return new int[] {left, right};
    }
}
