package chapter06;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 */
public class SumNums {
    /**
     * 不使用乘除法
     *
     * @param n
     * @return
     */
    public int sumNums(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumNums(n - 1);
    }

    /**
     * 使用乘除法
     *
     * @param n
     * @return
     */
    public int sumNums01(int n) {
        return (n + 1) * n / 2;
    }
}
