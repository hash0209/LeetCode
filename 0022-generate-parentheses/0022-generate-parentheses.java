class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
         gen(n,n, new StringBuilder(),res);
         return res;
    }

    public void gen(int open , int close , StringBuilder curr ,List<String> res){
        if(open == 0 && close == 0){
             res.add(curr.toString());
             return;
        }

        if(open == close){
               gen(open-1,close,curr.append("(") , res);
        }
        else{
            if(open!=0){
             int len = curr.length();
             gen(open-1,close,curr.append("(") , res);
             curr.setLength(len);
            }
             gen(open,close-1,curr.append(")") , res);

        }
              
    }
}