class Solution {
    public int minOperations(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        
        // Check if already sorted
        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        
        // If length is 2 and not sorted, we can't select a proper substring to sort
        if (n == 2) return -1;
        
        char minChar = s.charAt(0), maxChar = s.charAt(0);
        for (int i = 0; i < n; i++) {
            minChar = (char) Math.min(minChar, s.charAt(i));
            maxChar = (char) Math.max(maxChar, s.charAt(i));
        }
        
        // Check if 1 operation is enough
        // Min char at index 0 (and not all chars are equal) or max char at the last index
        if ((s.charAt(0) == minChar && s.charAt(n - 1) >= minChar) || 
            (s.charAt(n - 1) == maxChar && s.charAt(0) <= maxChar)) {
            // Ensure it's not a full-string trivial match if all chars are identical (handled by sorted check)
            // If min appears at start (proper prefix sort) or max appears at end (proper suffix sort)
            // Let's refine the exact condition for 1 operation:
        }
        
        // General logic implementation for 1, 2, 3, or -1 operations:
        // If min char is at index 0 (and not whole string) or max char is at index n-1:
        boolean minAtStart = (s.charAt(0) == minChar);
        boolean maxAtEnd = (s.charAt(n - 1) == maxChar);
        
        // Count occurrences
        int minCount = 0, maxCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == minChar) minCount++;
            if (s.charAt(i) == maxChar) maxCount++;
        }
        
        if (minAtStart || maxAtEnd) {
            return 1;
        }
        
        // Check if 3 operations are needed vs 2 operations
        // If the only max element is at the start and the only min element is at the end
        if (s.charAt(0) == maxChar && maxCount == 1 && s.charAt(n - 1) == minChar && minCount == 1) {
            return 3;
        }
        
        return 2;
    }
}