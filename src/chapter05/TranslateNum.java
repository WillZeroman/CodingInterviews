package chapter05;

/**
 * 剑指 Offer 46.
 * 把数字翻译成字符串
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class TranslateNum {

    /**
     * 递归
     * 有重复子问题
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        return countNum(str, 0, 1) + countNum(str, 0, 2);
    }

    private int countNum(String str, int i, int len) {
        if (i + len - 1 >= str.length()) {
            return 0;
        }
        if (!valid(str.substring(i, i + len))) {
            return 0;
        }
        if (i + len == str.length()) {
            return valid(str.substring(i, i + len)) ? 1 : 0;
        }
        return countNum(str, i + len, 1) + countNum(str, i + len, 2);
    }

    private boolean valid(String str) {
        if (str.length() > 1) {
            return !str.startsWith("0") && Integer.parseInt(str) < 26;
        }
        return Integer.parseInt(str) < 26;
    }

    /**
     * dp
     * O(n) O(n)
     *
     * @param num
     * @return
     */
    public int translateNum_best(int num) {
        String str = String.valueOf(num);
        if (str.length() < 2) {
            return str.length();
        }
        // dp[i] 为s[0..i]中转化字母的总数
        // dp[i] = dp[i-1] + dp[i-2] (if i-1和i的值有效)
        int[] dp = new int[str.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] += dp[i - 1];
            int data = Integer.parseInt(str.substring(i - 1, i + 1));
            if (10 <= data && data < 26) {
                if (i - 2 >= 0) {
                    dp[i] += dp[i - 2];
                } else {
                    dp[i] += 1;
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new TranslateNum().translateNum(12258));
        System.out.println(new TranslateNum().translateNum_best(12258));
        System.out.println(new TranslateNum().translateNum(111));
        System.out.println(new TranslateNum().translateNum(506));
        System.out.println(new TranslateNum().translateNum_best(506));
    }
}
