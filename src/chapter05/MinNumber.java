package chapter05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 剑指 Offer 45.
 * 把数组排成最小的数
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class MinNumber {
    /**
     * O(nlongn) O(n)
     *
     * xy > yx
     *
     * list 排序
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int firstNum = String.valueOf(num).charAt(0) - '0';
            List<Integer> list = map.getOrDefault(firstNum, new ArrayList<>());
            list.add(num);
            map.put(firstNum, list);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        StringBuilder ans = new StringBuilder();
        for (Integer num : keys) {
            List<Integer> list = map.get(num);
            Collections.sort(list, (o1, o2) -> {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return (s1 + s2).compareTo(s2 + s1);
            });
            for (Integer value : list) {
                ans.append(value);
            }
        }

        return ans.toString();
    }

    /**
     * O(nlongn) O(n)
     * array 排序
     * @param nums
     * @return
     */
    public String minNumber_best(int[] nums){
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr,(o1,o2)->{
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            return (s1 + s2).compareTo(s2 + s1);
        });
        StringBuilder ans = new StringBuilder();
        for(String str:arr){
            ans.append(str);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MinNumber().minNumber(new int[]{10, 2}));
        System.out.println(new MinNumber().minNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(new MinNumber().minNumber(new int[]{121, 12}));
        System.out.println(new MinNumber().minNumber_best(new int[]{121, 12}));
    }
}
