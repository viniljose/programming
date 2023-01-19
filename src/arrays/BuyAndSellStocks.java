package arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing
 * a different day in the future to sell that stock.
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Hint:If we plot the numbers of the given array on a graph,We need to find the largest peak following the smallest valley.
 * You keep two variables maxProfit and minimumPrice and populate it,minimumPrice will get reset if current price is lesser.
 * maxProfit will reset if current price - minimumPrice is greater than maxProfit
 */
public class BuyAndSellStocks {

    public int maxProfit(int[] prices) {
        int maxProfit =0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<minPrice)
                minPrice=prices[i];
            else if (prices[i]-minPrice>maxProfit)
                maxProfit=prices[i]-minPrice;
        }
        return maxProfit;
    }
}