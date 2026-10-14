import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class Solution {
    // Mapping from digit to corresponding letters
    private final Map<Character, String> digitToLetters = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );

    // List to store the final results
    private List<String> result;

    /**
     * Main method to initiate the letter combination generation.
     * @param digits The input string of digits (2-9).
     * @return A list of all possible letter combinations.
     */
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        
        // Handle the edge case of an empty input string
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        // Start the backtracking process
        backtrack(digits, 0, new StringBuilder());

        return result;
    }

    /**
     * The recursive backtracking function.
     * @param digits The original input digit string.
     * @param index The current digit being processed (position in the 'digits' string).
     * @param currentCombination The combination built so far.
     */
    private void backtrack(String digits, int index, StringBuilder currentCombination) {
        // Base case: If the current combination length equals the total number of digits,
        // a complete combination is formed.
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        // Get the current digit and its corresponding letters
        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);

        // Iterate through each letter for the current digit
        for (char letter : letters.toCharArray()) {
            // 1. CHOOSE: Append the letter to the current combination
            currentCombination.append(letter);

            // 2. EXPLORE: Recurse to the next digit
            backtrack(digits, index + 1, currentCombination);

            // 3. UNCHOOSE (Backtrack): Remove the last added letter to explore
            // the next letter choice at the current digit level
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }
}