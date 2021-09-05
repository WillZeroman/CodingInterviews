package chapter06;

/**
 * 剑指 Offer 55
 */
public class MaxDepth {
    /**
     * 剑指 Offer 55 - I.
     * 二叉树的深度
     * <p>
     * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 剑指 Offer 55 - II.
     * 平衡二叉树
     * <p>
     * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return balanceAndCount(root) != -1;
    }

    private int balanceAndCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        int countLeft = balanceAndCount(node.left);
        if (countLeft == -1) {
            return -1;
        }
        int countRight = balanceAndCount(node.right);
        if (countRight == -1) {
            return -1;
        }
        if (Math.abs(countLeft - countRight) > 1) {
            return -1;
        }
        return Math.max(countLeft, countRight) + 1;
    }
}
