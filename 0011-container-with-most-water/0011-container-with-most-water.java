class Solution {

    /**
     * Finds the two lines that, together with the x-axis, form a container
     * holding the most water.
     *
     * @param height An array of integers representing the heights of vertical lines.
     * @return The maximum amount of water a container can store.
     */
    public int maxArea(int[] height) {
        
        int maxArea = 0;
        int left = 0;                 // Pointer starting at the beginning of the array
        int right = height.length - 1; // Pointer starting at the end of the array

        // Loop until the pointers meet
        while (left < right) {
            
            // Calculate the width of the container
            int width = right - left;
            
            // Calculate the height of the container (limited by the shorter line)
            int h = Math.min(height[left], height[right]);
            
            // Calculate the area for the current pair of lines
            int area = width * h;
            
            // Update the maximum area found so far
            maxArea = Math.max(maxArea, area);
            
            // --- The Key Insight ---
            // We need to move one of the pointers.
            // If we move the pointer pointing to the *taller* line,
            // the new area will *always* be smaller or equal.
            // This is because the width decreases, and the height
            // is still limited by the *shorter* line.
            //
            // Therefore, we must move the pointer pointing to the
            // *shorter* line, as this is the only way we
            // have a *chance* of finding a larger area (by finding a
            // taller line to replace the current shorter one).
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}