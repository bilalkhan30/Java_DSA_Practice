public class SpecialArray {
    public static void main(String[] args) {
        
        int[] arr = {0,4,3,0,4};
        System.out.println(specialArray(arr));
    }

    public static int specialArray(int[] nums) {

        int n = nums.length;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int num : nums) {
                if (num >= i)
                    count++;
            }
            if (i == count)
                return i;
            else
                count = 0;

        }
        return -1;
    }
}