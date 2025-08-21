class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length-1 ; 

        for(int i = 0; i <= n ; i++){
            int[] row = matrix[i];

            int left =0; int right =n;

            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] =temp;
                left++;
                right--;
            }
        }



        for(int i = 0; i < n ; i++){
            for(int j =0; j < n-i ; j++){
               

                int temp =matrix[i][j];
                matrix[i][j] = matrix[n-j][n-i];
                matrix[n-j][n-i] = temp;
                

            }
        }
        
    }
}