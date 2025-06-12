class Solution {
    public void solveSudoku(char[][] board) {
        solve(0,0,board);
    }



    public boolean solve(int row , int col , char[][] board){
       boolean ans = false;

       if(row == 9){
        return true;
       }

        if(col == 9){
          return  solve(row+1, 0 , board);
        }

        if(board[row][col] != '.'){
           return solve(row,col+1,board);
        }

        for( int i = '1' ; i <='9';i++){
            if(isPossible(i , row , col , board)){
               
                board[row][col] = (char)i;
              ans =   solve(row,col+1,board);
              if(ans){
                return true;
              }
              else{
                board[row][col] = '.';
              }

            }
        }

        return false;
    }

    public boolean isPossible(int n , int row , int col , char[][] board){
        //check column 

        for(int i =0 ; i < 9 ; i++){
            int val = board[i][col];
            if(val == n){
                return false;
            }
        }

        //check row

        for(int i =0 ; i < 9;i++){
            int val = board[row][i];
            if(val == n){
                return false;
            }
        }

        int rowDup = row - (row%3);
        int colDup = col - (col%3);

        for(int i = rowDup ; i < rowDup+3 ; i++){
            for(int j = colDup ; j < colDup+3 ; j++){
                int val = board[i][j];
                if(val == n){
                    return false;
                }
            }
        }

        return true;



    }
}