public class BuySellStocks {
    public static void main(String[] args) {
        
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        
        int stockBought = prices[0]; // Keeps the track of stock bought
        int maxProfit = 0; // keeps the track of maxProfit
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < stockBought) {
                stockBought = prices[i]; // if a stock with less price is encountered than the stock bought than update stockBought
            } 
            else if(prices[i] - stockBought > maxProfit) {
                maxProfit = prices[i] - stockBought; // update the profit with respect to the stockBought
            }
        }
        return maxProfit;
    }
}
