package others;

public class ProfitForward {
    // brute force
    public static int maxProfit(int[] prices) {
       int maxprofit = 0;
       for(int i = 0; i < prices.length - 1; i++)
           for(int j = i + 1; j < prices.length; j++) {
               int profit = prices[j] - prices[i];
               if(profit > maxprofit) {
                   maxprofit = profit;
               }
           }
       return maxprofit;
    }

    public static int maxProfit1(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minprice) {
                minprice = prices[i];
            }
            else if(prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {5,50,2,10}));
        System.out.println(maxProfit1(new int[] {5,50,2,10}));
    }
}
