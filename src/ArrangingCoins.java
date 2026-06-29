public class ArrangingCoins {
    public static void main(String[] args) {
        
        System.out.println(arrangeCoins(5));
    }

    public static int arrangeCoins(int n) {

        return (int) Math.floor((Math.sqrt(8 * (long) n + 1) - 1) / 2);

    }
}
