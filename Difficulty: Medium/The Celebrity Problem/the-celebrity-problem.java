class Solution {
    public int celebrity(int mat[][]) {
        // code here
        //scan column 
        
        
        int ans=-1;
        
        
        for(int col =0 ; col < mat[0].length ; col++){
            
            boolean scanCol = true;
            
           for(int row =0 ; row < mat.length ; row++){
               if(mat[row][col] == 0){
                   scanCol = false;
                   break;
               }
           }
           
           if(scanCol){
               
               boolean scanRow = true;
               for(int row = 0 ; row < mat[0].length ; row++){
                   if(mat[col][row] == 1 && row!=col){
                       scanRow = false;
                       break;
                   }
               }
               
               if(scanRow){
                   return col;
               }
           }
           
        }
        
        return ans;
        
        
    }
}