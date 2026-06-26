public class MissingNumber {
    public static void main(String[] args) {
        
        System.out.println(Solution.missingNumber(new int[] {4, 0, 1, 2}));
    }
}

class Solution {
    public static int missingNumber(int[] nums) {

        int n = nums.length;
        int sum1 = 0; // Tracks the sum of all the elements in nums which will be the sum of natural number 1 to n.
        int sum2 = n * (n + 1) / 2; // Sum of all numbers from 1 to until the size of the array;
        for (int num : nums) {
            sum1 += num;
        }
        return (sum2 - sum1); // sum2 - sum1 will result in the missing number since only one number is mising from the sequance 0 to n
    }
}
