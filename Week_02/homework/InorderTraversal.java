package homework;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * User: Yinghao
 * Date: 2021/1/31
 * Time: 2:32 PM
 * Desc:
 *  二叉树的中序遍历
 *  Leetcode链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 *  1. 递归
 *  @see #inorderTraversal_1(TreeNode)
 *
 *  2. 栈
 *  @see #inorderTraversal_2(TreeNode)
 */
public class InorderTraversal {

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;

        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * 使用栈做中序遍历时，我们需要注意找到"最左的"那个结点，其要么为叶子结点，要么其还存在右子树。
     * 若为前者，则将该结点的值加入到结果列表中并返回上一层根节点；否则将其作为新的根，重复上面步骤。
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            // 循环直到找到该结点没有左结点为止
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop(); // "最左"结点
            res.add(root.val);
            root = root.right; // 若其右结点为空，则直接放回其上一层的根节点
        }

        return res;
    }
}
