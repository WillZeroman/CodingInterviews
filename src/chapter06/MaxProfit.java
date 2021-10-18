package chapter06;

/**
 * 剑指 Offer 63. 股票的最大利润
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * 一次遍历
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int ans = prices[1] - min;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            ans = Math.max(ans, prices[i] - min);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
