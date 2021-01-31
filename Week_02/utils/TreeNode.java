package utils;

/**
 * User: Yinghao
 * Date: 2021/1/31
 * Time: 2:35 PM
 * Desc: Binary Tree Node
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
