package homework;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * User: Yinghao
 * Date: 2021/1/31
 * Time: 3:38 PM
 * Desc:
 *  二叉树的前序遍历
 *  Leetcode链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 *  1. 递归
 *  @see #preorderTraversal_1(TreeNode)
 *
 *  2. 栈
 *  @see #preorderTraversal_2(TreeNode)
 */
public class PreorderTraversal {

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;

        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();

            res.add(root.val);
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }

        return res;
    }

}
