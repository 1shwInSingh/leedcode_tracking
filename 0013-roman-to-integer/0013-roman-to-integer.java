import java.util.Map;
import java.util.HashMap;

class Solution {

    /**
     * Converts a Roman numeral string to its integer representation.
     *
     * @param s The Roman numeral string.
     * @return The integer value.
     */
    public int romanToInt(String s) {
        
        // Map to store the integer value of each Roman symbol
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        // Get the value of the last character (which is always added)
        // and initialize the total.
        int total = map.get(s.charAt(s.length() - 1));
        
        // Iterate backward from the second-to-last character
        for (int i = s.length() - 2; i >= 0; i--) {
            
            // Get the value of the current character
            int currentVal = map.get(s.charAt(i));
            
            // Get the value of the character to its right (which we've already processed)
            int nextVal = map.get(s.charAt(i + 1));
            
            // The key insight:
            // If the current character's value is *less than* the one on its right,
            // it's a subtractive case (like 'I' in 'IV').
            if (currentVal < nextVal) {
                total -= currentVal; // Subtract its value
            } else {
                // Otherwise, it's an additive case (like 'L' in 'LVIII').
                total += currentVal; // Add its value
            }
        }
        
        return total;
    }
}