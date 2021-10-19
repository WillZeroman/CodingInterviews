package chapter07;

import java.util.HashMap;
import java.util.Map;

/**
 * 最近公共祖先
 */
public class LowestCommonAncestor {

    /**
     * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
     * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorForBST(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cursor = root;
        while (true) {
            if (cursor.val > p.val && cursor.val > q.val) {
                cursor = cursor.left;
            } else if (cursor.val < p.val && cursor.val < q.val) {
                cursor = cursor.right;
            } else {
                return cursor;
            }
        }
    }

    /**
     * 剑指 Offer 68 - II. 二叉树的最近公共祖先
     * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
     * <p>
     * 转化为链表，找公共节点
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorForCommonTree(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        preorder(root, null, map);
        TreeNode pCursor = p;
        TreeNode qCursor = q;
        while (pCursor != qCursor) {
            pCursor = pCursor != null ? map.get(pCursor) : q;
            qCursor = qCursor != null ? map.get(qCursor) : p;
        }
        return pCursor;
    }

    private void preorder(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (node != null) {
            map.put(node, parent);
            TreeNode nextParent = node;
            preorder(node.left, nextParent, map);
            preorder(node.right, nextParent, map);
        }
    }
}
