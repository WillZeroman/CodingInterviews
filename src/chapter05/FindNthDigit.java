package chapter05;

/**
 * 剑指 Offer 44
 * 数字序列中某一位的数字
 * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 */
public class FindNthDigit {
    /**
     * 1) 查找位数
     * 2）查找哪个数
     * 3）这个数的第几位
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        long sum = 9;
        int digit = 1;
        long start = 1;
        while (n > sum) {
            n -= sum;
            digit++;
            start *= 10;
            sum = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        int div = (n - 1) % digit;
        return String.valueOf(num).charAt(div) - '0';
    }

    public static void main(String[] args) {
        System.out.println(new FindNthDigit().findNthDigit(11));
        System.out.println(new FindNthDigit().findNthDigit(12));
        System.out.println(new FindNthDigit().findNthDigit(13));
        System.out.println(new FindNthDigit().findNthDigit(3));
        long num = 1 << 31;
        System.out.println(num);
        System.out.println(1 << 1);
    }
}
