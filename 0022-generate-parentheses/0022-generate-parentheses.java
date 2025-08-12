class Solution {
    public List<String> generateParenthesis(int n) {
        return find(n, n, new StringBuilder());

    }

    public List<String> find(int left , int right , StringBuilder res){

        List<String> ans = new ArrayList<String>();

        if(left == 0 && right == 0){
            ans.add(res.toString());
            return ans; 
        }


        if(left == right ){

            ans.addAll(find(left-1,right, res.append("(")));
        }
        else{
            if(left!=0){
                int len = res.length();
                 ans.addAll(find(left-1,right , res.append("(")));
                res.setLength(len);
            }

             ans.addAll(find(left , right-1 , res.append(")")));


        }

        return ans;


    }
}