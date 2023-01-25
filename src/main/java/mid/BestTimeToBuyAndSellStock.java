package mid;

public class BestTimeToBuyAndSellStock {
  public int maxProfit(int[] prices) {
    int max = 0;
    int l = 0;
    int r = l+1;
//    for (int i = 0; i < prices.length; i++) {
//      for (int j = i+1; j < prices.length; j++) {
//        max = Math.max(max, prices[j]-prices[i]);
//      }
//    }
    while (r<prices.length) {
      if(prices[l] < prices[r]) {
        int profit = prices[r]-prices[l];
        max = Math.max(max, profit);
        r++;
      }
      else {
        l++;
        r++;
      }
    }

    return max;

  }
}
