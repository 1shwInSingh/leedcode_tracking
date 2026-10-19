class Solution {
    public int divide(int dividend, int divisor) {
        // Handle 32-bit integer overflow edge case: -2^31 / -1 = 2^31 (overflows)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the quotient
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to negative long values to prevent overflow with Integer.MIN_VALUE
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int quotient = 0;

        // Bit manipulation: subtract divisor * 2^i from dividend
        for (int i = 31; i >= 0; i--) {
            if ((a >> i) >= b) {
                quotient += 1 << i;
                a -= b << i;
            }
        }

        return negative ? -quotient : quotient;
    }
}