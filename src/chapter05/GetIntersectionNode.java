package chapter05;

/**
 * 剑指 Offer 52.
 * 两个链表的第一个公共节点
 * <p>
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * <p>
 * 方法1：O(m+n) O(m)
 * 使用hashset将a链表的所有节点存起来，然后依次遍历链表b，找到第一个在hashset中相等的node。
 * 方法2：O(m) O(1)
 * 先依次遍历，分别得到两个链表的长度m 和 n；假设m>n,然后链表a先走m-n步，然后两个链表依次遍历。
 */
public class GetIntersectionNode {
    /**
     * O(m+n) O(1)
     * 两个指针，如果a遍历完在遍历b；
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}
