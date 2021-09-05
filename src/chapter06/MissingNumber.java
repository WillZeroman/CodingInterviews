package chapter06;

/**
 * 指 Offer 53 - II.
 * 0～n-1中缺失的数字
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
