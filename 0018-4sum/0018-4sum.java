import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        if (n < 4) {
            return result;
        }

        // 1. Sort the array. This is crucial for:
        //    a) Easily skipping duplicates.
        //    b) Using the Two Pointers technique efficiently.
        Arrays.sort(nums);

        // Outer loop: Fix the first element (a)
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Second loop: Fix the second element (b)
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for the second element
                // Note: j must start at i + 1, and we check against j - 1 which is > i
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 3. Two Pointers Technique: Find the remaining two elements (c and d)
                // The required sum for the two pointers is:
                // twoSumTarget = target - nums[i] - nums[j]
                long twoSumTarget = (long)target - nums[i] - nums[j];

                int left = j + 1; // Left pointer starts right after j
                int right = n - 1; // Right pointer starts at the end

                while (left < right) {
                    long currentSum = (long)nums[left] + nums[right];

                    if (currentSum == twoSumTarget) {
                        // Found a valid quadruplet
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Move pointers to search for the next distinct pair
                        left++;
                        right--;

                        // Skip duplicates for the third element (c)
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        // Skip duplicates for the fourth element (d)
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }

                    } else if (currentSum < twoSumTarget) {
                        // Need a larger sum, move the left pointer right
                        left++;
                    } else { // currentSum > twoSumTarget
                        // Need a smaller sum, move the right pointer left
                        right--;
                    }
                }
            }
        }

        return result;
    }
}