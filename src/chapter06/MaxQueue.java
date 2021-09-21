package chapter06;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II.
 * 队列的最大值
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 *
 * 大顶堆
 *
 */
public class MaxQueue {
    private Queue<Integer> queue = new LinkedList<>();
    private PriorityQueue<Integer> maxValue = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public MaxQueue() {

    }

    public int max_value() {
        return maxValue.isEmpty() ? -1 : maxValue.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        maxValue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            int res = queue.poll();
            maxValue.remove(res);
            return res;
        }
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }
}
