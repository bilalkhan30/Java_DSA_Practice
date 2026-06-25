public class ValidPerfectSquare {
    public static void main(String[] args) {
        
        System.out.println(Solution.isPerfectSquare(16));
    }
}

class Solution {
    public static boolean isPerfectSquare(int num) {

        if (num == 1) {
            return true;
        }
        // For num > 1 we use binary search for finding the sqrt of the given number between 1 to num/2
        int start = 1;
        int end = num / 2; // the square root of a number > 1 will always be less than number/2
        long mid = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            long sqr = mid * mid;
            if (sqr == (long) num) {
                return true;
            } else if (sqr > (float) num) {
                end = (int) mid - 1;
            } else {
                start = (int) mid + 1;
            }
        }
        return false;
    }
}