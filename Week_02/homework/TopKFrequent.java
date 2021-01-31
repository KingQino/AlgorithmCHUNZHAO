package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * User: Yinghao
 * Date: 2021/1/31
 * Time: 6:29 PM
 * Desc:
 *  前K个高频元素
 *  Leetcode链接：https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 *  解题思路：
 *  1. 先将元素装入Map中，元素为key，元素出现频次为value。后将map中元素放入优先队列，重新定义comparator
 *  @see #topKFrequent(int[], int) 
 */
public class TopKFrequent {

    /**
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(N)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i,0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().getKey();
        }

        return res;
    }
}
