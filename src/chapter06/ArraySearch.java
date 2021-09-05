package chapter06;

/**
 * 剑指 Offer 53 - I.
 * 在排序数组中查找数字 I
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class ArraySearch {

    /**
     * O(logn) O(1)
     * 分别查找左右边界
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        //find left
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // find; 顺序遍历
//        int ans = 0;
//        while (left<nums.length && nums[left] == target) {
//            ans++;
//            left++;
//        }
        // 二分查找
        int l = left;
        if(nums[left]!=target){
            return 0;
        }
        right = nums.length-1;
        while (left<=right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid]<=target){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left-l;
    }

    public static void main(String[] args) {
        System.out.println(new ArraySearch().search(new int[]{5, 7, 7, 8, 8, 10}, 5));
        System.out.println(new ArraySearch().search(new int[]{5, 7, 7, 8, 8, 10}, 7));
        System.out.println(new ArraySearch().search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(new ArraySearch().search(new int[]{5, 7, 7, 8, 8, 10}, 10));
        System.out.println(new ArraySearch().search(new int[]{5, 7, 7, 8, 8, 10}, 9));
        System.out.println(new ArraySearch().search(new int[]{5, 7, 7, 8, 8, 10}, 11));
        System.out.println(new ArraySearch().search(new int[]{5, 7, 7, 8, 8, 10}, 4));
    }
}
