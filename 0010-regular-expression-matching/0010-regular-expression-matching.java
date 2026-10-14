// This is the ONE and ONLY class definition
class Solution {

    /**
     * Implements regular expression matching with support for '.' and '*'.
     * This solution uses dynamic programming (bottom-up).
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int m = s.length();
        int n = p.length();

        // dp[i][j] will be true if the first i chars of s match the first j chars of p
        boolean[][] dp = new boolean[m + 1][n + 1];

        // 1. Base Case: Empty string vs. Empty pattern
        // An empty string matches an empty pattern.
        dp[0][0] = true;

        // 2. Fill the first row (empty string s vs. pattern p)
        // This handles cases like p = "a*", p = "a*b*", etc.
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                // If we see a '*', it can match zero of the preceding element.
                // So, we look at the result from two steps back in the pattern.
                // e.g., if p is "a*", dp[0][2] depends on dp[0][0]
                dp[0][j] = dp[0][j - 2];
            }
            // else, dp[0][j] remains false (default)
        }

        // 3. Fill the rest of the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                
                char sChar = s.charAt(i - 1); // Current char in s
                char pChar = p.charAt(j - 1); // Current char in p

                if (pChar == '.' || pChar == sChar) {
                    // Case 1: Simple match (chars are equal or pattern is '.')
                    // The result depends on whether the substrings *before*
                    // these characters matched.
                    dp[i][j] = dp[i - 1][j - 1];
                    
                } else if (pChar == '*') {
                    // Case 2: Pattern char is '*'
                    // This '*' refers to the preceding character in p, p.charAt(j - 2)
                    
                    // Option A: The '*' matches *zero* of the preceding element.
                    // We effectively ignore the "x*" part (e.g., "a*")
                    // and check if s (up to i) matches p (up to j-2).
                    boolean matchZero = dp[i][j - 2];

                    // Option B: The '*' matches *one or more* of the preceding element.
                    // This is only possible if the current sChar matches the 
                    // character *before* the '*' (p.charAt(j - 2)).
                    boolean charMatches = (sChar == p.charAt(j - 2) || p.charAt(j - 2) == '.');
                    
                    // If the char matches, we "consume" the sChar and see if
                    // the *same* pattern (with the '*') could match the *shorter* string s.
                    boolean matchOneOrMore = charMatches && dp[i - 1][j];
                    
                    // The result is true if either option is possible.
                    dp[i][j] = matchZero || matchOneOrMore;

                } else {
                    // Case 3: Mismatch
                    // e.g., sChar = 'a', pChar = 'b'
                    // The result is false (which is the default value).
                    dp[i][j] = false;
                }
            }
        }

        // The final answer is in the bottom-right corner,
        // representing the match of the full string s vs. the full pattern p.
        return dp[m][n];
    }
} // This should be the *only* closing brace for the Solution class