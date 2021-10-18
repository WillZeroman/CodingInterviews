package chapter06;

import java.util.Arrays;

/**
 * 剑指 Offer 61.
 * 扑克牌中的顺子
 *
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 */
public class Straight {
    public boolean isStraight(int[] nums) {
        if (nums.length != 5) {
            return false;
        }
        Arrays.sort(nums);
        int countS = 0;
        int dif = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countS++;
            } else {
                if (i > 0 && nums[i - 1] != 0) {
                    int tmpDif = nums[i] - nums[i - 1];
                    if (tmpDif == 0) {
                        return false;
                    }
                    dif += tmpDif - 1;
                }
            }
        }
        return dif <= countS;
    }
}
