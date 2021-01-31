package homework;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import utils.Node;

import java.util.*;

/**
 * User: Yinghao
 * Date: 2021/1/31
 * Time: 12:25 PM
 * Desc:
 *  N叉树的后序遍历
 *  Leetcode链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 *
 *  解题思路：
 *  1. 递归
 *  @see #postorder_1(Node)
 *
 */

public class Postorder {

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param root
     * @return
     */
    public List<Integer> postorder_1(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        for (Node node : root.children) {
            helper(node, res);
        }
        res.add(root.val);
    }

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * 特别注意，我们最后需要反转结果，这是因为栈每次弹出来的结果都是最先被加入到结果列表里的，
     * 即先根后孩子，所以最后需要将其反转。
     *
     * @param root
     * @return
     */
    public List<Integer> postorder_2(Node root) {
        if (root == null) return null;

        List<Integer> res = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            for (Node node : root.children) {
                stack.push(node);
            }
            res.add(root.val);
        }

        Collections.reverse(res);
        return res;
    }


}
