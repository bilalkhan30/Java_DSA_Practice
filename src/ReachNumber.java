public class ReachNumber {
    
    public static void main(String[] args) {
        
        int target = -1000000000;
        System.out.println(reachNumber(target));
    }

    public static int reachNumber(int target) {

        target = Math.abs(target); // due to symmetry in number line the number of steps it takes to reach the positive target will be equals to number of steps to reach it's counter -ve.
        long start = 1;
        long end = target;
        long minSteps = 0;
        long numReached = 0;
        // performing binary search on the number of steps
        while (start <= end) {
            long mid = start + (end - start)/2; // step value
            numReached = mid*(mid + 1)/2; // number we can reach this mid steps
            if (numReached >= target) {
                minSteps = mid; // minSteps to reach or juts exceed the target
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }

        }

        numReached = minSteps*(minSteps + 1)/2; // Calculate the numReached again with minSteps

        if ((numReached - target) % 2 == 0) { // if difference is even then that many steps will be required to reach the target which will be required to the number just greater than target
            return (int) minSteps;
        }
        else {
            if (minSteps % 2 != 0) { // for odd difference check the steps taken are odd or even. If odd then 2 more steps will be required to reach the target
                return (int) minSteps + 2;
            }
            else {
                return (int) minSteps + 1;
            }
        }
    }
}
