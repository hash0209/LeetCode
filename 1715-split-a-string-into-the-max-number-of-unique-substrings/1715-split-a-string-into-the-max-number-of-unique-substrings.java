class Solution {
    public int maxUniqueSplit(String s) {
        return split(0,s,new HashSet<>());
    }


    public int split(int idx , String s , Set<String> ds){
          if(idx == s.length()){
            return ds.size();
          }
         

          int max= 0;

          for(int i =idx+1; i <= s.length(); i++){
                 if(ds.contains(s.substring(idx,i))){
                    continue;
                 }
              ds.add(s.substring(idx,i));
              max=  Math.max(split(i,s,ds),max);
              ds.remove(s.substring(idx,i));
          }
          return max;
    }
}