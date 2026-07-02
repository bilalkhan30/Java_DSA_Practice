import java.util.Arrays;
import java.util.HashSet;

public class FairCandySwap {
    public static void main(String[] args) {
        
        int[] aliceCandy = {1, 2, 5};
        int[] bobCandy = {2, 4};
        System.out.println(Arrays.toString(fairCandySwap(aliceCandy, bobCandy)));
    }

    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sumA = 0;
        int sumB = 0;
        int[] ans = new int[2];
        for (int c : aliceSizes) {
            sumA += c;
        }
        for (int c : bobSizes) {
            sumB += c;
        }
        HashSet<Integer> setB = new HashSet<>();
        // Building Hashset for fast access
        for(int c : bobSizes) {
            setB.add(c);
        }
        // Since bob and alice has to exchange one candy and sumA == sumB should remain the same after that
        // sumA = sumA - a + b (where alice gives candy a to bob and recieve b candy from the bob)
        // similary, sumB = sumB - b + a
        // for sumA == sumB, sumA - a + b = sumB - b + a, therefore b = a + (sumA - sumB)/2
        // hence if bob has the candy a + (sumA - sumB)/2 then return [a, a + diff] 
        int diff = (sumB - sumA)/2;
        for(int c : aliceSizes) {
            if(setB.contains(c + diff)) {
                ans[0] = c;
                ans[1] = c + diff;
            }
        }
        return ans;
    }
}
