class Solution {
    public int minimumSwap(String s1, String s2) {

         int xy =0;
         int yx =0;

         for(int i =0; i < s1.length() ; i++){
            if(s1.charAt(i)==s2.charAt(i)){
                continue;
            }
             if(s1.charAt(i)=='x' && s2.charAt(i)=='y'){
                xy++;
             }
             else{
                yx++;
             }
         }

         if(xy == 0 && yx ==0){
            return 0;
         }

         int swaps =0;

         swaps+= xy/2;

         xy = xy%2;


         swaps+= yx/2;

         yx = yx%2;

         if(xy == yx){
            swaps+= 2 * xy;
            return swaps;
         }

         return -1;




         











        

    }
}