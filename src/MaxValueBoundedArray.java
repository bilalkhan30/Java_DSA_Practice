public class MaxValueBoundedArray {

    public static void main(String[] args) {
        System.out.println(maxValue(3, 2, 18)); // Output should be 7
    }

    public static int maxValue(int n, int index, int maxSum) {

        long maxVal = 0;
        long leftSpace = index;
        long rightSpace = n - index - 1;
        long start = 1;
        long end = maxSum;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long leftSum = 0, rightSum = 0;

            // Calculate Left Side
            if (leftSpace <= mid - 1) {
                leftSum = (mid - 1) * mid / 2 - ((mid - leftSpace - 1) * (mid - leftSpace)) / 2;
            } else {
                leftSum = (mid - 1) * mid / 2 + (leftSpace - mid + 1);
            }

            // Calculate Right Side
            if (rightSpace <= mid - 1) {
                rightSum = (mid - 1) * mid / 2 - ((mid - rightSpace - 1) * (mid - rightSpace)) / 2;
            } else {
                rightSum = (mid - 1) * mid / 2 + (rightSpace - mid + 1);
            }

            long totalSum = leftSum + rightSum + mid;

            if (totalSum > maxSum) {
                end = mid - 1;
            } else {
                start = mid + 1;
                maxVal = mid;
            }
        }
        
        return (int) maxVal;
    }
}