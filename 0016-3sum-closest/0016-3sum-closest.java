import java.util.Arrays;

class Solution {

    /**
     * Finds three integers in nums such that the sum is closest to target.
     *
     * @param nums   The input array of integers.
     * @param target The target integer.
     * @return The sum of the three integers that is closest to target.
     */
    public int threeSumClosest(int[] nums, int target) {
        
        // 1. Sort the array
        Arrays.sort(nums);
        
        // 2. Initialize closestSum
        // We are guaranteed nums.length >= 3, so this is safe.
        int closestSum = nums[0] + nums[1] + nums[2];
        
        // 3. Main loop (fix 'i')
        // We go up to n-2 because we need at least two more elements (low and high)
        for (int i = 0; i < nums.length - 2; i++) {
            
            // Optimization: Skip duplicates for the fixed element 'i'
            // This isn't strictly necessary for correctness but speeds it up.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // 4. Two-pointer setup
            int low = i + 1;
            int high = nums.length - 1;
            
            while (low < high) {
                // 5. Calculate the current sum
                int currentSum = nums[i] + nums[low] + nums[high];
                
                // 6. Check for a perfect match
                if (currentSum == target) {
                    return target; // Can't get any closer than the exact target
                }
                
                // 7. Check if this sum is closer than the one we have
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                // 8. Move the pointers
                if (currentSum < target) {
                    low++; // Sum is too small, need a larger number
                } else {
                    high--; // Sum is too large, need a smaller number
                }
            }
        }
        
        // 9. Return the final closest sum
        return closestSum;
    }
}
