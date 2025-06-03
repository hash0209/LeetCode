// User function Template for Java//User function Template for Java
class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        
        return find(0,arr,0);
    }
    
    
    public static ArrayList<Integer> find(int idx , int[] arr , int sum ){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        if(idx == arr.length-1 ){
            
            ans.add(sum + arr[idx]);
            ans.add(sum);
            return ans;
            
        }
        
        
        ans.addAll(find(idx+1,arr,sum+arr[idx]));
        ans.addAll(find(idx+1,arr,sum));
        
        return ans;
    }
}

