package chapter06;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 59 - I.
 * 滑动窗口的最大值
 * <p>
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
public class MaxSlidingWindow {
    /**
     * 优先级队列
     * O(n*logk) O(k)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);

        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        for (int i = k; i < nums.length; i++) {
            ans[index] = queue.peek();
            index++;
            queue.offer(nums[i]);
            queue.remove(nums[i - k]);
        }
        ans[index] = queue.peek();
        return ans;
    }

    /**
     * 单调队列
     * O(n) O(k)
     *
     * 边界判定
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow_best(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
        }
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        for (int i = k; i < nums.length; i++) {
            ans[index] = queue.peekFirst();
            index++;
            // 从队尾往前遍历，如果小于则删除队尾元素
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
            // 如果队首元素为滑动窗口之外的元素需要剔除掉
            if (queue.peekFirst() == nums[i - k]) {
                queue.removeFirst();
            }
        }
        ans[index] = queue.peekFirst();
        return ans;
    }

    public static void main(String[] args) {
        int[] data = {1, -1};
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow_best(data, 2)));
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(data, 2)));
    }
}
