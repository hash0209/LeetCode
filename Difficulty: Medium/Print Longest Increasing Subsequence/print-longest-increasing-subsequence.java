// User function Template for Java

class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        int maxf = 1;
        int maxidx = 0;
        int[] dp = new int[arr.length];
        int[] prev = new int[arr.length];
        Arrays.fill(prev,-1);
        Arrays.fill(dp,1);
        
        
        for(int i =0; i < arr.length ; i++){
            for(int j =0; j < i ; j++){
                if(arr[j] < arr[i]){
                    if(dp[i] <  dp[j]+1){
                    dp[i] = dp[j]+1;
                    prev[i] = j;
                    if(dp[i] > maxf){
                        maxf = dp[i];
                        maxidx = i;
                    }
                }
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        
        while(maxidx !=-1){
            list.add(arr[maxidx]);
            maxidx = prev[maxidx];
            
        }
        
        Collections.reverse(list);
        
        return list;
        
        
        
        
        
    
    }
}
