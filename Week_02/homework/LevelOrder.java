package homework;

import utils.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * User: Yinghao
 * Date: 2021/1/31
 * Time: 3:48 PM
 * Desc:
 *  N叉树的层序遍历
 *  Leetcode链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 *
 *  解题思路：
 *  1. 广度优先搜索 队列 这个解法的关键在标识每一层
 *  @see #levelOrder_1(Node)
 *
 */
public class LevelOrder {

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_1(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            res.add(level);
        }

        return res;
    }
}
