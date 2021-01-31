package practice;

import java.util.PriorityQueue;

/**
 * User: Yinghao
 * Date: 2021/1/31
 * Time: 6:18 PM
 * Desc:
 *  滑动窗口的最大值
 *  Leetcode链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 *
 *  解题思路：
 *  1. priority queue 大顶堆
 *  @see #
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1]; // number of windows

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int i = 0; i < n; ++i) {
            int start = i - k;
            if (start >= 0) {
                maxPQ.remove(nums[start]);
            }
            maxPQ.offer(nums[i]);
            if (maxPQ.size() == k) {
                result[i - k + 1] = maxPQ.peek();
            }
        }

        return result;
    }
}
