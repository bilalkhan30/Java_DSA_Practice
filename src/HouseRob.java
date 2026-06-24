import java.util.Arrays;
import java.util.ArrayList;

public class HouseRob {
    public static void main(String[] args) {

        int[] nums = {2, 7, 9, 3, 1};
        int n = nums.length;
        boolean[] canRob = new boolean[n + 2];
        Arrays.fill(canRob, 1, n, true);
        int maxProfit = 0;

        while (hasTrueValues(canRob)) {

            int robbing = findMax(nums, trueIndex(canRob));
            maxProfit += nums[robbing];
            canRob[robbing - 1] = false;
            canRob[robbing + 1] = false;

        }

        System.out.println(maxProfit);

    }

    private static boolean hasTrueValues(boolean[] arr) {

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] == true)
                return true;
        }
        return false;
    }

    private static ArrayList<Integer> trueIndex(boolean[] arr) {

        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] == true) {
                index.add(i - 1);
            }
        }

        return index;
    }

    private static int findMax(int[] arr, ArrayList<Integer> index) {

        int max = index.get(0);
        for (int i = 0; i < index.size(); i++) {
            int idx = index.get(i);
            if (arr[idx] > arr[max])
                max = idx;
        }
        return max;
    }
}
