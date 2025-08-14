class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // base for valid substring calculation
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // push index of '(' onto the stack
                stack.push(i);
            } else {
                // c == ')'
                if (!stack.isEmpty()) {
                    stack.pop(); // pop matching '(' index
                }

                if (stack.isEmpty()) {
                    // no matching '(', set new base
                    stack.push(i);
                } else {
                    // valid substring length = current_index - last unmatched '(' index
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}