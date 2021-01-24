class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || k == 0) return;

        // 方法一 时间O(N)，空间O(N)
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; ++i) {
            temp[(i + k) % len] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, len);

    }
}
