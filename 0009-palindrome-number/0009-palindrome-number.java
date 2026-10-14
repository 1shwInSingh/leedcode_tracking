public class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindrome
        // Also, numbers ending with 0 but not 0 itself are not palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        // Reverse half of the number
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // When the length is odd, we can get rid of the middle digit by reversedHalf/10
        // For even length numbers, x should be equal to reversedHalf
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
