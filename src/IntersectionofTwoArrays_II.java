import java.util.Arrays;
import java.util.HashMap;

public class IntersectionofTwoArrays_II {
    public static void main(String[] args) {
        
        int[] arr1 = {1,2,2,1};
        int[] arr2 = {2,2};
        System.out.println(Arrays.toString(intersect(arr1, arr2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        int[] res = new int[Math.max(nums1.length, nums2.length)];
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // Build a hashmap number(key) -> occurence in nums1(value)
        for(int n : nums1) {
            if(map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            }
            else {
                map.put(n, 1);
            }
        }
        // iterate through nums2 and check whether it is present in the map. If present add it to the result
        // and decreament the occurence in the map
        for(int n : nums2) {
            if(map.containsKey(n) && map.get(n) > 0) {
                res[count++] = n;
                map.put(n, map.get(n) - 1);
            } 
        }

        return Arrays.copyOf(res, count);
    }
}
