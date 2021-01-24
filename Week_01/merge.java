class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // p1,p2分别指向nums1和nums2有序部分的最后一个元素
        int p1 = m - 1; 
        int p2 = n - 1;
        // p指向nums1的末尾
        int p = m + n - 1;

        // p1,p2指向的值比较大小，大的放在nums1的末尾
        while(p1 >= 0 && p2 >= 0) {
            // if (nums1[p1] < nums2[p2]) {
            //     nums1[p--] = nums2[p2--];
            // } else {
            //     nums1[p--] = nums1[p1--];
            // }
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }

        // 如果p2先遍历完了nums2，则整个nums1已经是有序的，不需要额外操作
        // 如果p1先遍历完了nums1的前半部分，则需将nums2的未遍历部分完整地拷贝到nums1的前部
        if (p1 < 0 ) System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

    }
}
