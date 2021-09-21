package chapter06;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II.
 * 队列的最大值
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * <p>
 * 单调队列
 */
public class MaxQueue2 {
    private Queue<Integer> queue = new LinkedList<>();
    private Deque<Integer> maxValue = new LinkedList<>();

    public MaxQueue2() {

    }

    public int max_value() {
        return maxValue.isEmpty() ? -1 : maxValue.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!maxValue.isEmpty() && maxValue.peekLast() < value) {
            maxValue.removeLast();
        }
        maxValue.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            int res = queue.poll();
            if (res == maxValue.peekFirst()) {
                maxValue.removeFirst();
            }
            return res;
        }
    }

    public static void main(String[] args) {
        MaxQueue2 maxQueue = new MaxQueue2();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }
}
