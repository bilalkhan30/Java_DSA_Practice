import java.util.Arrays;

public class IntersectionofTwoArrays {
    public static void main(String[] args) {
        
        int[] nums1 = {4,9,5};
        int[] nums2 = { 9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int count = 0;
        boolean[] flag = new boolean[1001];
        // A flag array to mark whether a element is present or not
        for(int n : nums1) {
            flag[n] = true;
        }
        // comparing the elements of other array with the flag array whether they are also present to find the
        // common elements also turn the flag back to false to remove checking for duplicates
        for(int n : nums2) {
            if(flag[n] == true) {
                res[count++] = n;
                flag[n] = false;
            }
        }
        // returning the array without its default zero values put by JVM
        return Arrays.copyOf(res, count);
    }
}

