package chapter05;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 面试题 40
 * 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class GetLeastNumbers {

    /**
     * O(n * logK) O(k)
     * 遍历 + 堆
     * 不改变原数组
     *
     * @param arr data
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[]{};
        }
        if (k == arr.length) {
            return arr;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k + 1, (o1, o2) -> o2 - o1);
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] ans = new int[queue.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }

    /**
     * O(n) O(1)
     * 快排思想，递归
     * 改变原数组
     *
     * @param arr data
     * @param k
     * @return
     */
    public int[] getLeastNumbers_partition(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[]{};
        }
        if (k == arr.length) {
            return arr;
        }
        int left = 0;
        int right = arr.length - 1;
        int index = partition(arr, left, right);
        while (index != k - 1) {
            if (index > k - 1) {
                right = index - 1;
                index = partition(arr, left, right);
            } else {
                left = index + 1;
                index = partition(arr, left, right);
            }
        }
        return Arrays.copyOf(arr, k);
    }

    public int partition(int[] arr, int left, int right) {
        int flagValue = arr[left];
        while (left < right) {
            while (arr[right] >= flagValue && left < right) {
                right--;
            }
            arr[left] = arr[right];
            while (arr[left] <= flagValue && left < right) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = flagValue;
        return left;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GetLeastNumbers().getLeastNumbers(new int[]{4, 5,
                1, 6, 2, 7, 3, 8}, 4)));
        System.out.println(Arrays.toString(new GetLeastNumbers().getLeastNumbers_partition(new int[]{4, 5,
                1, 6, 2, 7, 3, 8}, 4)));
        System.out.println(Arrays.toString(new GetLeastNumbers().getLeastNumbers(new int[]{
                3, 2, 1}, 1)));
        System.out.println(Arrays.toString(new GetLeastNumbers().getLeastNumbers_partition(new int[]{
                3, 2, 1}, 1)));
        //[0,0,2,3,2,1,1,2,0,4]
        //10
        System.out.println(Arrays.toString(new GetLeastNumbers().getLeastNumbers_partition(new int[]{
                0, 0, 2, 3, 2, 1, 1, 2, 0, 4}, 10)));
    }
}
