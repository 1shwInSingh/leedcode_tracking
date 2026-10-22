class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int p0 = 0, pn = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) p0 = i;
            if (nums[i] == n - 1) pn = i;
        }

        boolean inc = true, dec = true;
        for (int i = 0; i < n && (inc || dec); i++) {
            if (nums[(p0 + i) % n] != i) inc = false;
            if (nums[(pn + i) % n] != n - 1 - i) dec = false;
        }

        if (inc) return Math.min(p0, p0 == 0 ? 0 : 2 + (n - p0) % n);
        if (dec) return Math.min(1 + (n - pn) % n, pn + 1);
        return -1;
    }
}