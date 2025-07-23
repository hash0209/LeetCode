class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        
        int[][] dp = new int[arr.length][sum+1];
        
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return isSubsetSum(arr , arr.length-1 , sum , dp);
    }
    
    static boolean  isSubsetSum(int[] arr , int i , int target , int[][] dp){
        if(target == 0){
            return true ; 
        }
        
        
        if(i == 0){
            return arr[0] == target;
        }
        
        if(dp[i][target]!=-1){
            return (dp[i][target] == 1)? true : false;
        }
        
        
        boolean take = false ; 
        
        if(target >= arr[i]){
            take = isSubsetSum(arr , i-1 , target-arr[i] , dp);
        }
        
        boolean notTake = isSubsetSum(arr , i-1 , target , dp);
        
        if(take || notTake){
            dp[i][target] = 1;
        }
        else{
            dp[i][target] = 0;
        }
        
        return  take || notTake ; 
            
        
    }
}