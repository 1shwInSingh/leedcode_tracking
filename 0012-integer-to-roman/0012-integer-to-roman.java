class Solution {

    /**
     * Converts an integer to its Roman numeral representation.
     *
     * @param num The integer to convert (1 <= num <= 3999).
     * @return The Roman numeral as a string.
     */
    public String intToRoman(int num) {
        
        // Define the corresponding values and symbols,
        // from largest to smallest.
        // Include the special subtractive cases (900, 400, 90, 40, 9, 4).
        int[] values = {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };
        
        String[] symbols = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        
        // Use StringBuilder for efficient string concatenation
        StringBuilder roman = new StringBuilder();
        
        // Iterate through the values/symbols array
        for (int i = 0; i < values.length && num > 0; i++) {
            
            // Greedily subtract the largest possible value from num
            // and append its corresponding symbol to the result.
            // This loop will run 0-3 times for each symbol (e.g., 3000 = "MMM")
            // and 0-1 times for the subtractive symbols (e.g., 900 = "CM").
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }
        
        return roman.toString();
    }
}