package chapter06;

import java.util.Arrays;

/**
 * 剑指 Offer 66. 构建乘积数组
 * https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 */
public class ConstructArr {
    /**
     * travel twice
     *
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return a;
        }
        int[] sum = new int[a.length];
        sum[0] = 1;
        for (int i = 1; i < a.length; i++) {
            sum[i] = sum[i - 1] * a[i - 1];
        }
        int tempSum = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            sum[i] *= tempSum;
            tempSum *= a[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ConstructArr().constructArr(new int[]{1, 2, 3, 4,
                5})));
        System.out.println(Arrays.toString(new ConstructArr().constructArr(new int[]{5})));
        System.out.println(Arrays.toString(new ConstructArr().constructArr(new int[]{5, 4})));
    }
}
