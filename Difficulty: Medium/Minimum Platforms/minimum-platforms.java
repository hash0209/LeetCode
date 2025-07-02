// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
      int p =1;
      int pMax= 1;
      
      int depindex = 0;
      
      for(int i =1 ; i < arr.length; i ++){
          if(arr[i] > dep[depindex]){
              depindex++;
          }
          else{
              p++;
              pMax =Math.max(pMax , p );
          }
      }
      
      
      return p;
      
      
    }
}
