package chapter06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 剑指 Offer 57
 */
public class TwoSum {

    /**
     * 剑指 Offer 57
     * 和为s的两个数字
     * <p>
     * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[0];
    }

    /**
     * 剑指 Offer 57 - II.
     * 和为s的连续正数序列
     *
     * O(n) O(1)
     * <p>
     * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int left = target / 2;
        int right = left + 1;
        List<int[]> list = new ArrayList<>();
        while (left > 0) {
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum == target) {
                int[] tempArray = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    tempArray[i - left] = i;
                }
                list.add(tempArray);
                left--;
                right--;
            } else if (sum < target) {
                left--;
            } else {
                right--;
            }
        }
        if (list.isEmpty()) {
            return new int[][]{};
        }
        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);
        int[][] ans = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] res = new TwoSum().findContinuousSequence(15);
        for (int[] num : res) {
            System.out.println(Arrays.toString(num));
        }
        res = new TwoSum().findContinuousSequence(9);
        for (int[] num : res) {
            System.out.println(Arrays.toString(num));
        }
    }
}
