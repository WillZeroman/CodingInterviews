package chapter05;

import java.util.Arrays;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class ReversePairs {
    /**
     * O(n^2) O(1)
     * 暴力求解
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int first = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int second = nums[j];
                if (first > second) {
                    ans++;
                }
            }
        }

        return ans;
    }

    /**
     * 归并
     * O(nlogn) O(n)
     * @param nums
     * @return
     */
    public int reversePairs_best(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int ans = sort(nums, 0, nums.length - 1);
        return ans;
    }

    private int sort(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        if (left + 1 == right) {
            if(nums[left]>nums[right]){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                return 1;
            }
            return 0;
        }
        int mid = left +(right-left)/2;
        int leftPair = sort(nums,left,mid);
        int rightPair = sort(nums,mid+1,right);
        // merge
        int mergePair = 0;
        int i = left;
        int j = mid+1;
        int[] arr = new int[right-left+1];
        int k = 0;
        while (i<=mid&&j<=right){
            if(nums[i]>nums[j]){
                arr[k] = nums[j];
                j++;
                mergePair += mid - i + 1;
            } else {
                arr[k] = nums[i];
                i++;
            }
            k++;
        }
        while (i<=mid){
            arr[k] = nums[i];
            k++;
            i++;
        }
        while (j<=right){
            arr[k] = nums[j];
            k++;
            j++;
        }
        for(i=left,k=0;i<=right;i++,k++){
            nums[i] = arr[k];
        }
        return leftPair + rightPair + mergePair;
    }


    public static void main(String[] args) {
        System.out.println(new ReversePairs().reversePairs(new int[]{7, 7,5, 6, 4}));
        System.out.println(new ReversePairs().reversePairs_best(new int[]{7,7, 5, 6, 4}));
        System.out.println(new ReversePairs().reversePairs(new int[]{7}));
        System.out.println(new ReversePairs().reversePairs_best(new int[]{7}));
    }
}
