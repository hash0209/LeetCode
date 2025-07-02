class Solution {
    public boolean checkValidString(String s) {
        

      

        int idx=0;

        Stack<Character> pst = new Stack<>();

        Stack<Character> ast = new Stack<>();
        while(idx < s.length()){
            char i = s.charAt(idx);

            if(i == '('){
                pst.push(i);
            }
            else if( i == '*'){
                ast.push(i);
            }
            else{
                if(!pst.isEmpty()){
                    pst.pop();
                }
                else if(!ast.isEmpty()){
                    ast.pop();
                }
                else{
                    return false;
                }
            }
            idx++;
        }

        if(pst.isEmpty()){
            return true;
        }
        

        pst.clear();
        ast.clear();

        idx =s.length()-1;
        while(idx >=0){
            char i = s.charAt(idx);

            if(i == ')'){
                pst.push(i);
            }
            else if( i == '*'){
                ast.push(i);
            }
            else{
                if(!pst.isEmpty()){
                    pst.pop();
                }
                else if(!ast.isEmpty()){
                    ast.pop();
                }
                else{
                    return false;
                }
            }
            idx--;
        }
        return true;
    }
}