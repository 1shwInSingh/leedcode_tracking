import java.util.ArrayList;
import java.util.List;

class Solution {
    
    // This is the method signature the driver code is looking for.
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        
        // Check for edge case if needed, though constraints usually guarantee 1 <= n
        if (n <= 0) {
            return result;
        }

        // The core recursive logic starts here
        backtrack(result, new StringBuilder(), 0, 0, n);
        
        return result;
    }

    /**
     * The recursive backtracking function to build the valid combinations.
     */
    private void backtrack(List<String> result, StringBuilder current, int openCount, int closeCount, int max) {
        
        // Base Case: A combination is complete when the length is 2*n
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // Rule 1: Add '(' if we haven't used all 'n' open brackets.
        if (openCount < max) {
            current.append('(');
            backtrack(result, current, openCount + 1, closeCount, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }

        // Rule 2: Add ')' if the number of close brackets is less than the number of open brackets.
        if (closeCount < openCount) {
            current.append(')');
            backtrack(result, current, openCount, closeCount + 1, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}