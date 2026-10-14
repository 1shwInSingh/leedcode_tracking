class Solution {
    
    /**
     * Implements the myAtoi(string s) function, which converts a string 
     * to a 32-bit signed integer.
     */
    public int myAtoi(String s) {
        
        // 1. Handle null or empty string
        if (s == null || s.length() == 0) {
            return 0;
        }

        int index = 0;
        int sign = 1;     // Positive by default
        int result = 0;
        int n = s.length();
        
        // Define integer limits for overflow checking
        int INT_MAX = Integer.MAX_VALUE; // 2147483647
        int INT_MIN = Integer.MIN_VALUE; // -2147483648

        // 2. Ignore leading whitespace
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // 3. Check for signedness (+ or -)
        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++; // Move past the sign character
        }

        // 4. Convert digits and handle overflow
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Check for overflow *before* it happens.
            // We are about to calculate: result = result * 10 + digit
            
            // If result * 10 would already overflow, or
            // If result * 10 is at the limit and the new digit causes overflow
            
            // Check positive overflow
            if (result > INT_MAX / 10 || (result == INT_MAX / 10 && digit > 7)) {
                return (sign == 1) ? INT_MAX : INT_MIN;
            }
            
            // If no overflow, perform the update
            result = result * 10 + digit;
            
            // Move to the next character
            index++;
        }

        // 5. Return the final result with the correct sign
        return result * sign;
    }
}