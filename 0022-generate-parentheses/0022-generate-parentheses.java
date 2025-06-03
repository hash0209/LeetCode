class Solution {
    public List<String> generateParenthesis(int n) {
        return gen("",n ,n);
    }

    public List<String> gen(String para , int open , int close ){

        List<String> ans = new ArrayList<String>();
        if(open == 0 && close ==0){
            ans.add(para);
            return ans; 
        }

        if(open!=0){
            List<String> list1 = gen(para.concat("("),open-1,close);
            ans.addAll(list1);
        }
        if(open!=close){
            List<String> list2 = gen(para.concat(")"),open,close-1);
            ans.addAll(list2);
        }
        return ans;
    }
}