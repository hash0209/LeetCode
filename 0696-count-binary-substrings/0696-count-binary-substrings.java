class Solution {
    public int countBinarySubstrings(String s) {
          List<Integer> list = new ArrayList<>();

          int count=1;

          for(int i =1; i < s.length();i++){
             if(s.charAt(i) == s.charAt(i-1)){
                count++;
             }
             else{
                list.add(count);
                count=1;

             }
          }
          list.add(count);

          int ans=0;

          for(int i =1; i < list.size();i++){
              ans+= Math.min(list.get(i),list.get(i-1));
          }

          return ans;
          

        
    }
}