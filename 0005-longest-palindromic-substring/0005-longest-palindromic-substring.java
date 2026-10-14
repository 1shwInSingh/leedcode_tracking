class Solution {
    private int start = 0;
    private int maxLength = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            // Check for odd length palindromes (center is at i)
            expandAroundCenter(s, i, i);
            // Check for even length palindromes (center is at i and i+1)
            expandAroundCenter(s, i, i + 1);
        }

        return s.substring(start, start + maxLength);
    }

    private void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // The loop breaks when the condition is no longer met.
        // The length of the palindrome is (right - 1) - (left + 1) + 1 = right - left - 1
        int currentLength = right - left - 1;
        if (currentLength > maxLength) {
            maxLength = currentLength;
            // The starting index is left + 1 because the while loop decrements left one extra time
            start = left + 1;
        }
    }
}