package chapter06;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 */
public class LastRemaining {

    /**
     * 迭代递推
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LastRemaining().lastRemaining(5, 3));
    }
}
