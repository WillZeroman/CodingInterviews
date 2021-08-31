package chapter05;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 49.
 * 丑数
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 */
public class NthUglyNumber {
    /**
     * O(nlongn) O(n)
     * 堆 + hash
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] data = {2, 3, 5};
        PriorityQueue<Long> queue = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        queue.offer(1L);
        set.add(1L);
        for (int i = 0; i < n - 1; i++) {
            long key = queue.poll();
            for (int num : data) {
                long nextKey = key * num;
                if (set.add(nextKey)) {
                    queue.offer(nextKey);
                }
            }
        }
        long ans = queue.poll();
        return (int) ans;
    }

    /**
     * O(n) O(n)
     * dp
     *
     * @param n
     * @return
     */
    public int nthUglyNumber_best(int n) {
        if (n == 1) {
            return 1;
        }
        // dp[i] 表示第i个丑数，
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            int num = Math.min(num2, Math.min(num3, num5));
            if (num == num2) {
                p2++;
            }
            if (num == num3) {
                p3++;
            }
            if (num == num5) {
                p5++;
            }
            dp[i] = num;
        }
        System.out.println(Arrays.toString(dp));

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new NthUglyNumber().nthUglyNumber(10));
        System.out.println(new NthUglyNumber().nthUglyNumber_best(10));
    }
}
