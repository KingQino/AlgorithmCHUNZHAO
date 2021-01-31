package homework;

import utils.Node;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: Yinghao
 * Date: 2021/1/31
 * Time: 2:02 PM
 * Desc:
 *  N叉树的前序遍历
 *  Leetcode链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 *
 *  1. 递归
 *  @see #preorder_1(Node)
 *  
 *  2. 栈
 *  @see #preorder_2(Node) 
 */
public class Preorder {

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param root
     * @return
     */
    public List<Integer> preorder_1(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        for (Node node : root.children) {
            helper(node, res);
        }
    }

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param root
     * @return
     */
    public List<Integer> preorder_2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            // 此处需要注意，按照前序遍历的定义-先根后孩子，我们应该将root结点的孩子从后往前依次压入栈，
            // 这样才能让最后去访问的孩子在栈的底部，而最先访问的孩子在栈的头部
            Collections.reverse(root.children);
            for (Node node : root.children) {
                stack.push(node);
            }
        }

        return res;
    }
}
