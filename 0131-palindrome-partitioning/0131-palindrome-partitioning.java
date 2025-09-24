class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();
        find(0,s,res,new ArrayList<>());
        return res;
        
    }

    public void find(int idx , String s , List<List<String>> list , List<String> current){
         if(idx == s.length()){
             list.add(new ArrayList<>(current));
             return;
         }


         for(int i = idx+1 ; i <= s.length() ;i++){
               if(checkPalindrome( idx ,  i-1 ,  s)){
                    current.add(s.substring(idx,i));
                    find(i ,s,list , current);
                    current.remove(current.size()-1);
               }
         }
    }

    public boolean checkPalindrome(int start , int end , String s){
          while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
          }
          return true;
    }
}