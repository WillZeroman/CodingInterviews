package chapter05;

import java.util.PriorityQueue;

/**
 * 面试题 41
 * 数据流中的中位数
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 * <p>
 * 堆的实现：建堆，插入数字
 */
public class MedianFinder {
    /**
     * 存放[n/2,n]的数值
     */
    private PriorityQueue<Integer> smallHeap;

    /**
     * 存放[0,n/2]的数值
     */
    private PriorityQueue<Integer> bigHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        smallHeap = new PriorityQueue<>();
        bigHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        if (smallHeap.size() == bigHeap.size()) {
            bigHeap.offer(num);
            smallHeap.offer(bigHeap.poll());
        } else {
            smallHeap.offer(num);
            bigHeap.offer(smallHeap.poll());
        }
    }

    public double findMedian() {
        if (smallHeap.size() == 0) {
            throw new IllegalStateException("Wrong status");
        }
        return smallHeap.size() != bigHeap.size() ? smallHeap.peek() :
                (smallHeap.peek() + bigHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());
    }
}
