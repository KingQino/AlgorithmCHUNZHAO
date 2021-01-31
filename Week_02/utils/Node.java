package utils;

import java.util.List;

/**
 * User: Yinghao
 * Date: 2021/1/31
 * Time: 12:29 PM
 * Desc: N-ary Tree Node
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
