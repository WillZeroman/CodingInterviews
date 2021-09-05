package chapter06;

import java.util.Arrays;

/**
 * 剑指 Offer 56
 */
public class SingleNumbers {
    /**
     * 剑指 Offer 56-I
     * 数组中数字出现的次数
     * <p>
     * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int value = nums[0];
        for (int i = 1; i < nums.length; i++) {
            value ^= nums[i];
        }
        String bi = Integer.toBinaryString(value);
        int i = bi.length() - 1;
        for (; i >= 0; i--) {
            if (bi.charAt(i) == '1') {
                break;
            }
        }
        int split = 1 << (bi.length() - i - 1);
        int first = 0;
        int second = 0;
        for (int j = 0; j < nums.length; j++) {
            if ((split & nums[j]) == 0) {
                first ^= nums[j];
            } else {
                second ^= nums[j];
            }
        }

        int[] ans = new int[]{first, second};
        return ans;
    }

    /**
     * 剑指 Offer 56 - II.
     * 数组中数字出现的次数 II
     * 遍历
     * <p>
     * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                int bit = num & (1 << i);
                if (bit != 0) {
                    count[i]++;
                }
            }
        }
        System.out.println(Arrays.toString(count));
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int c = count[i];
            if (c % 3 != 0) {
                ans += (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumbers().singleNumber2(new int[]{3, 4, 3, 3}));
    }
}
