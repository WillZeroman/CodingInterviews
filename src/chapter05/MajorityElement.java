package chapter05;

import java.util.HashMap;

/**
 * 数组中出现次数超过一半的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 */
public class MajorityElement {
    /**
     * O(n),O(n)
     * hash
     *
     * @param nums data
     * @return
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int half = nums.length >> 1;
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            count++;
            if (count > half) {
                return nums[i];
            }
            map.put(nums[i], count);
        }
        return 0;
    }

    /**
     * O(n) O(1)
     * 投票算法
     *
     * @param nums data
     * @return
     */
    public int majorityElement_best(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count++;
            } else {
                if (candidate == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4
                , 2}));
        System.out.println(new MajorityElement().majorityElement_best(new int[]{1, 2, 3, 2, 2, 2,
                5, 4, 2}));
        System.out.println(new MajorityElement().majorityElement_best(new int[]{1, 2, 1, 1, 2}));
    }
}
