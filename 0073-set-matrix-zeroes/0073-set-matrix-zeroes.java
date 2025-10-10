class Solution {
    public void setZeroes(int[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;

        boolean[] rowZero = new boolean[r];
        boolean[] colZero = new boolean[c];


        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    rowZero[i] = true;
                    colZero[j]= true;
                }
            }
        }

        for(int row =0; row < r ; row++){
            if(rowZero[row]){
                for(int col =0; col < c ; col++){
                      matrix[row][col] =0;
                }
            }
        }


         for(int col =0; col < c ; col++){
            if(colZero[col]){
                for(int row =0; row < r ; row++){
                      matrix[row][col] =0;
                }
            }
        }
    }
}


