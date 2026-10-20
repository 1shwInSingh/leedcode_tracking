class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        java.util.ArrayDeque<Integer> stack = new java.util.ArrayDeque<>();
        
        // Base marker before the start of the string
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // Current ')' cannot be matched; becomes the new base marker
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}