// User function Template for Java

class Solution {
    static String minWindow(String s1, String s2) {
        // code here
        
        
        int minlen = Integer.MAX_VALUE;
        
        String ans = "";
        
       
        int l =0;
        
        while(l < s1.length()){
           int start  =  findStartingPoint(l , s1,s2);
           if(start == -1){
               return ans;
           }
           int end =  findWindow(start,s1,s2);
           if(end ==-1){
               return ans;
           }
           
           int minStart = findminWindow(end , s1,s2);
           
           int len = end-minStart+1;
           
           if(minlen > len){
               minlen = len ;
               ans = s1.substring(minStart , end+1);
           }
           
           l =minStart+1;
           
           
        }
        
        return ans;
        
        
        
        
       
        
    }
    
    
    
    static int findStartingPoint(int idx , String s1 , String s2){
        while(idx < s1.length()){
            if(s1.charAt(idx) == s2.charAt(0)){
                return idx;
            }
            idx++;
        }
        
        return -1;
    }
    
    
    static int findWindow(int idx , String s1 , String s2){
        int l = idx ;
        int r =0;
        int count = 0;
        
        while(l < s1.length() && r < s2.length()){
            if(s1.charAt(l) == s2.charAt(r)){
              r++;
              count++;
            }
            l++;
        }
        
        if(count == s2.length()){
            return l-1;
        }
        else{
            return -1;
        }
    }
    
    
    static int findminWindow(int idx , String s1 , String s2){
        
        int r = s2.length()-1;
        while(r >=0){
            if(s1.charAt(idx) == s2.charAt(r)){
                r--;
            }
            idx--;
        }
        
        return idx+1;
    }
        
       
}



