class Solution {

    //int[] rows
    //int[] cols
    //traverse the matrix mark row & col as zero
    //treaverse the matrix to cell as 0
    public void setZeroes(int[][] matrix) {

        int m = matrix.length-1;
        int n = matrix[0].length-1;

        boolean firstRow = false;
        boolean firstCol = false;

        for(int c =0; c <= n ; c++ ){
            if(matrix[0][c]==0){
                firstRow =true;
            }

        }

         for(int c =0; c <= m ; c++ ){
            if(matrix[c][0]==0){
                firstCol =true;
            }

        }

        for(int i =1; i <= m ; i++){
            for(int j =1; j <= n ; j++){
                if(matrix[i][j]== 0){
                    matrix[0][j] =0;
                    matrix[i][0]=0;
                }
            }
        }


        for(int i =1; i <= m ; i++){
            for(int j =1; j <= n ; j++){
                 if(matrix[0][j]==0 || matrix[i][0] ==0){
                           matrix[i][j]=0;
                 }
            }
        }

        if(firstRow){
            for(int i =0; i <= n ; i++){
                matrix[0][i]=0;
            }
        }

         if(firstCol){
            for(int i =0; i <= m ; i++){
                matrix[i][0]=0;
            }
        }



        
    }
}