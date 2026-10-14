import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * Determines if the input string containing parentheses is valid.
     * Time Complexity: O(n), where n is the length of the string, as we iterate through the string once.
     * Space Complexity: O(n), in the worst case (e.g., "((((("), the stack will hold n/2 elements.
     * * @param s The input string containing parentheses.
     * @return true if the string is valid, false otherwise.
     */
    public boolean isValid(String s) {
        // Create a map to store the relationships between closing and opening brackets.
        Map<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        // Initialize a stack to keep track of open brackets.
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Case 1: If 'c' is a closing bracket (it's a key in the mappings map)
            if (mappings.containsKey(c)) {
                
                // Get the expected opening bracket from the map.
                char expectedOpen = mappings.get(c);

                // Get the actual opening bracket from the stack.
                // If the stack is empty, there is no corresponding open bracket for the current close bracket.
                // We use a placeholder ('#') if the stack is empty to prevent an Exception.
                char topElement = stack.isEmpty() ? '#' : stack.pop();

                // Check if the actual open bracket matches the expected open bracket.
                if (topElement != expectedOpen) {
                    return false;
                }

            } else {
                // Case 2: If 'c' is an opening bracket
                // Push it onto the stack to be closed later.
                stack.push(c);
            }
        }

        // After iterating through the entire string, the stack must be empty 
        // if every open bracket has been correctly closed.
        return stack.isEmpty();
    }
}