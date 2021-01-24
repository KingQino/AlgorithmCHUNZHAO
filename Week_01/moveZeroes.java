/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null) return;

        // 方法一
        // int j = 0;
        // for (int i = 0; i < nums.length; ++i) {
        //     if (nums[i] != 0) {
        //         nums[j] = nums[i];
        //         if (i != j) {
        //             nums[i] = 0;
        //         }
        //         j++;
        //     }
        // }

        // 方法二
        int len = nums.length;
        int j = 0;
        for (int i = 0; i < len; ++i) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        // 第一次遍历结束，j的左边都是非零数，j本身和其右边都应为零
        for (int i = j; i < len; i++) {
            nums[i] = 0;
        }

    }
}

