package chapter06;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 */
public class TwoAdd {
    /**
     * 异或 + 与运算
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) << 1;
        while (carry != 0) {
            int oldSum = sum;
            sum = sum ^ carry;
            carry = (oldSum & carry) << 1;
        }
        return sum;
    }

    public int add_best(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new TwoAdd().add_best(3, 2));
        System.out.println(new TwoAdd().add_best(7, 1));
        System.out.println(new TwoAdd().add_best(100, 100));
    }
}
