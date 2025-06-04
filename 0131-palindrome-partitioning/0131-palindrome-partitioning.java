class Solution {
    public List<List<String>> partition(String s) {

        return part(s);

    }

    public List<List<String>> part(String str) {


        List<List<String>> ans = new ArrayList<>();

        if (str.isEmpty()) {
            return new ArrayList<>();
        }

        for (int i = str.length()-1; i>=0; i--) {
            String l = str.substring(i,str.length());

            boolean isPalindrome = checkPalindrome(l);
            if (isPalindrome) {
                String r = str.substring(0,i);
                List<List<String>> res = part(r);

                if (!res.isEmpty()) {
                    for (List<String> l1 : res) {
                        l1.add(l);
                    }
                } else {

                    List<String> l1 = new ArrayList<>();
                    l1.add(l);
                    res.add(l1);

                }

                ans.addAll(res);

            }

           
        }
         return ans;
    }

    public boolean checkPalindrome(String str) {
        int l = 0;
        int r = str.length() - 1;

        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;

        }

        return true;
    }

}