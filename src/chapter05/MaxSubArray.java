package chapter05;

/**
 * 剑指 Offer 42.
 * 连续子数组的最大和
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class MaxSubArray {
    /**
     * dp
     * O(n),O(n)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0]= nums[0];
        int max = arr[0];
        for(int i=1;i<nums.length;i++){
            arr[i] = Math.max(arr[i-1]+nums[i],nums[i]);
            max = Math.max(arr[i],max);
        }
        return max;
    }
}
