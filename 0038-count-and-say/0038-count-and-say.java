class Solution {
    public String countAndSay(int n) {
        String result = "1";

        for (int step = 1; step < n; step++) {
            StringBuilder sb = new StringBuilder();
            int len = result.length();

            for (int i = 0; i < len; ) {
                char ch = result.charAt(i);
                int count = 0;

                // Count consecutive identical characters
                while (i < len && result.charAt(i) == ch) {
                    count++;
                    i++;
                }

                // Append count followed by the digit
                sb.append(count).append(ch);
            }

            result = sb.toString();
        }

        return result;
    }
}