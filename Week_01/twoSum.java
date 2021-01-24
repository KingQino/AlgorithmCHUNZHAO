class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;

        int[] res = new int[2];
        loopOut:
        for (int i = 0; i < nums.length - 1; ++i) {
            int another = target - nums[i]; 
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] == another) {
                    res[0] = i; 
                    res[1] = j;
                    break loopOut;
                }
            }
        }

        return res;
    }
}
