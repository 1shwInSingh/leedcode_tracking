import java.util.Arrays;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int totalSum = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            if (isSortable(nums, sorted, n, k)) {
                totalSum += k;
            }
        }

        return totalSum;
    }

    private boolean isSortable(int[] nums, int[] sorted, int n, int k) {
        for (int start = 0; start < n; start += k) {
            int dropCount = 0;
            int dropIdx = -1;

            for (int i = 0; i < k; i++) {
                int curr = nums[start + i];
                int next = nums[start + (i + 1) % k];
                if (curr > next) {
                    dropCount++;
                    dropIdx = i;
                }
            }

            // More than 1 drop means it cannot be rotated into sorted order
            if (dropCount > 1) {
                return false;
            }

            // Offset is uniquely 0 if no drops, or (dropIdx + 1) % k if 1 drop
            int offset = (dropCount == 1) ? (dropIdx + 1) % k : 0;

            // Direct O(k) verification
            for (int i = 0; i < k; i++) {
                if (nums[start + (offset + i) % k] != sorted[start + i]) {
                    return false;
                }
            }
        }

        return true;
    }
}