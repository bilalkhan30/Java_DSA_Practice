import java.util.Arrays;
import java.util.HashMap;

public class FindRightInterval {
    
    public static void main(String[] args) {
        
        int[][] intervals = {{1,4},{2,3},{3,4}};
        System.out.println(Arrays.toString(findRightInterval(intervals)));
    }

    public static int[] findRightInterval(int[][] intervals) {

        HashMap<Integer, Integer> map = new HashMap<>(); // using to map out the indices of start
        int[] start = new int[intervals.length]; // store only the start interval for sorting
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
        }
        Arrays.sort(start);
        for (int i = 0; i < res.length; i++) {
            // binary Searching the sorted start array for element which is just greater than or equal to end interval
            // passing map to get the oriignal index of start from the input array
            res[i] = binarySearch(start, intervals[i][1], map);
        }
        return res;
    }

    public static int binarySearch(int[] nums, int target, HashMap<Integer, Integer> map) {

        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target)
                return map.get(nums[mid]);
            else if(target < nums[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        if(0 <= start && start < nums.length)
            return map.get(nums[start]);
        else
            return -1;
    }
}
