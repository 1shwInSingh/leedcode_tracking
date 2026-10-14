import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    /**
     * Finds all unique triplets in the array which give the sum of zero.
     *
     * @param nums The input array of integers.
     * @return A list of all unique triplets that sum to zero.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        
        // 1. Sort the array. This is crucial for the two-pointer
        //    technique and for handling duplicates.
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // 2. Iterate through the array. 'i' will be the first element
        //    of the potential triplet. We only need to go up to n-2.
        for (int i = 0; i < n - 2; i++) {
            
            // 3. Skip duplicate 'i' values.
            //    If this element is the same as the one before it,
            //    we've already processed all triplets starting with that number.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 4. Use the Two-Pointer technique on the rest of the array.
            int low = i + 1;
            int high = n - 1;
            int target = -nums[i]; // We need (nums[low] + nums[high]) == -nums[i]

            while (low < high) {
                int currentSum = nums[low] + nums[high];

                if (currentSum == target) {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));

                    // 5. Skip duplicates for the 'low' pointer
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    
                    // 6. Skip duplicates for the 'high' pointer
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }

                    // Move both pointers inward to find the next potential triplet
                    low++;
                    high--;
                    
                } else if (currentSum < target) {
                    // The sum is too small, need a larger number.
                    // Move the 'low' pointer to the right.
                    low++;
                } else { // currentSum > target
                    // The sum is too large, need a smaller number.
                    // Move the 'high' pointer to the left.
                    high--;
                }
            }
        }
        
        return result;
    }
}