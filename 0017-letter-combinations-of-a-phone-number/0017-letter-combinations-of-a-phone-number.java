class Solution {
    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        Map<Character, List<String>> map = new HashMap<>();

        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));

        char[] ch = digits.toCharArray();

        List<String> ans = map.get(ch[0]);

        if (ch.length == 1) {
            return ans;
        }

    
        for (int i = 1; i < ch.length; i++) {
            List<String> curr = map.get(ch[i]);

              ans = merge(ans,curr);
            
        }

        return ans;

    }

    public List<String> merge(List<String> str1, List<String> str2) {
        List<String> ans = new ArrayList<>();

        for (String s1 : str1) {
            for (String s2 : str2) {
                ans.add(s1.concat(s2));
            }
        }
        return ans;
    }

}