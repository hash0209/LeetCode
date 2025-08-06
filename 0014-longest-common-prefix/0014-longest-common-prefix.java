class Solution {
    public String longestCommonPrefix(String[] strs) {

        String prefix = (strs.length > 0) ? strs[0] : "";

        for (int i = 1; i < strs.length; i++) {

            String curr = strs[i];

            StringBuilder temp = new StringBuilder();

            int l = Math.min(prefix.length(), curr.length());

            int idx = 0;

            while (idx < l) {
                if (prefix.charAt(idx) != curr.charAt(idx)) {
                    break ;
                } 
                temp.append(prefix.charAt(idx));
                    idx++;
            }

            prefix = temp.toString();
        }

        return prefix;

    }
}