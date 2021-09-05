package chapter06;

/**
 * 剑指 Offer 54.
 * 二叉搜索树的第k大节点
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class KthLargest {
    private int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        TreeNode node = inOrder(root);
        return node != null ? node.val : -1;
    }

    private TreeNode inOrder(TreeNode node) {
        if (node != null) {
            TreeNode target = null;
            if (node.right != null) {
                target = inOrder(node.right);
            }
            if (target == null) {
                if (k == 1) {
                    return node;
                }
                k--;
            }
            if (target == null && node.left != null) {
                target = inOrder(node.left);
            }
            return target;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(new KthLargest().kthLargest(root, 1));
        System.out.println(new KthLargest().kthLargest(root, 2));
        System.out.println(new KthLargest().kthLargest(root, 3));
        System.out.println(new KthLargest().kthLargest(root, 4));
    }
}
