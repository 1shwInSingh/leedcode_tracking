class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;

        if (totalLength % 2 == 1) {
            // Odd number of elements, find the middle element
            return findKth(nums1, 0, m - 1, nums2, 0, n - 1, totalLength / 2 + 1);
        } else {
            // Even number of elements, find the average of the two middle elements
            double first = findKth(nums1, 0, m - 1, nums2, 0, n - 1, totalLength / 2);
            double second = findKth(nums1, 0, m - 1, nums2, 0, n - 1, totalLength / 2 + 1);
            return (first + second) / 2.0;
        }
    }

    private int findKth(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2, int k) {
        // Ensure nums1 is the shorter array to optimize space and avoid boundary issues
        if (r1 - l1 > r2 - l2) {
            return findKth(nums2, l2, r2, nums1, l1, r1, k);
        }
        
        // Base cases
        if (l1 > r1) {
            return nums2[l2 + k - 1];
        }
        if (l2 > r2) {
            return nums1[l1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[l1], nums2[l2]);
        }

        // Recursive step
        int mid1 = l1 + Math.min(k / 2, r1 - l1 + 1) - 1;
        int mid2 = l2 + Math.min(k / 2, r2 - l2 + 1) - 1;

        if (nums1[mid1] < nums2[mid2]) {
            // Discard the first part of nums1
            return findKth(nums1, mid1 + 1, r1, nums2, l2, r2, k - (mid1 - l1 + 1));
        } else {
            // Discard the first part of nums2
            return findKth(nums1, l1, r1, nums2, mid2 + 1, r2, k - (mid2 - l2 + 1));
        }
    }
}