class Solution {
    public boolean isMatch(String s, String p) {
        return find(s, s.length(), p, p.length());
    }

    public boolean find(String s, int x, String p, int y) {
        if (x == 0 && y == 0) {
            return true;
        }

        if (y == 0) {
            return false;
        }

        if (x == 0) {

            while (y > 0 && p.charAt(y - 1) == '*') {
                y=y-2;
            }
            return (y == 0);
        }

        if (p.charAt(y - 1) == '.' || s.charAt(x - 1) == p.charAt(y - 1)) {
            return find(s, x - 1, p, y - 1);
        }

        if (p.charAt(y - 1) == '*') {
           boolean ans1 = find(s,x,p ,y-2);
           boolean ans2= false;
           if(p.charAt(y-2)== '.'||p.charAt(y-2)==s.charAt(x-1)){
            ans2 = find(s,x-1,p,y);
           }
           return ans1 || ans2;
        }

        return false;
    }
}