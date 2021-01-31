package practice;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * User: Yinghao
 * Date: 2021/1/31
 * Time: 4:55 PM
 * Desc:
 *  最小的K个数
 *  Leetcode链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 *
 *  解题思路：
 *  1. sort
 *  @see #getLeastNumbers_1(int[], int)
 *
 *  2. priority queue - 假设是使用heap实现的
 *  @see #getLeastNumbers_2(int[], int)
 *
 */
public class LeastKNumbers {

    /**
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(N)
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers_1(int[] arr, int k) {
        int[] res = new int[k];
        Arrays.sort(arr);
        res = Arrays.copyOf(arr, k);
        return res;
    }

    /**
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(N)
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers_2(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) return res;

        // 默认是小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }

        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }

        return res;
    }

}
