// User function Template for Java

class Solution {
    static int solve(int bt[]) {
        
        Arrays.sort(bt);
        // code here
        int wt =0;
        int t =0;
        
        for (int i =0 ; i < bt.length ; i++){
            wt=wt+t;
            t=t+bt[i];
        }
        
        return wt / bt.length;
    }
}
