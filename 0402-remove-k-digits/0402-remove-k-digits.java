class Solution {
    public String removeKdigits(String num, int k) {
        char[] c = num.toCharArray();

        int allowed = num.length() - k;

        Stack<Character> s = new Stack<>();
        for (int i = 0; i < c.length; i++) {
            while (!s.isEmpty() && s.peek()  > c[i] ) {

                if (k == 0) {
                    break;
                } else {
                    s.pop();
                    k--;
                }
            }

            if (s.size() < allowed) {
                  s.push(c[i]);                
                }
            else {
                k--;
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!s.isEmpty()) {
            ans.append(s.pop());
        }
        ans.reverse();

        if (ans.isEmpty()) {
            return "0";
        }

        int idx = 0;
        while (idx < ans.length() - 1 && ans.charAt(idx) == '0') {
            idx++;
        }
        return ans.substring(idx);

    }
}