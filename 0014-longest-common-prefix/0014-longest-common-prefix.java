class Solution {

    /**
     * Finds the longest common prefix string amongst an array of strings.
     * This method uses a "vertical scanning" approach.
     *
     * @param strs The array of strings.
     * @return The longest common prefix, or "" if none exists.
     */
    public String longestCommonPrefix(String[] strs) {
        
        // 1. Handle edge cases
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Take the first string as the reference for the prefix
        String firstStr = strs[0];
        if (firstStr.isEmpty()) {
            return "";
        }

        // 2. Vertically scan character by character
        // Iterate through each character of the first string
        for (int i = 0; i < firstStr.length(); i++) {
            
            // Get the character to check
            char charToMatch = firstStr.charAt(i);
            
            // Compare this character against all other strings at the same index
            for (int j = 1; j < strs.length; j++) {
                
                // Check for two failure conditions:
                // a) The current string is shorter than the index 'i'
                // b) The character at index 'i' in the current string does not match
                if (i >= strs[j].length() || strs[j].charAt(i) != charToMatch) {
                    
                    // If either fails, the prefix ends *before* index 'i'.
                    // Return the substring from the start up to (but not including) 'i'.
                    return firstStr.substring(0, i);
                }
            } // <-- Closes the inner for-loop
        } // <-- Closes the outer for-loop
        
        // 3. If the loop completes
        // The entire first string is the common prefix
        return firstStr;
        
    } // <-- This brace closes the 'longestCommonPrefix' method
    
} // <-- This brace closes the 'Solution' class