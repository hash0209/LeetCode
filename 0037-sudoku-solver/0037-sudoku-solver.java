class Solution {
    public void solveSudoku(char[][] board) {

        boolean[][] rows= new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];

        for(int i = 0; i < board.length ; i++){
            for(int j =0; j < board[0].length ; j++){
                if(board[i][j] =='.'){
                    continue;
                }

                int num = board[i][j]-'0';
                int box = (i/3)*3 +(j/3);

                rows[i][num] = cols[j][num] = boxes[box][num]= true;
                

            }
        }

        solve(0,0,board,rows,cols,boxes);


        
        

       

        
    }

    public boolean solve(int row , int idx , char[][] board , boolean[][]  rows , boolean[][] cols , boolean[][] boxes){

                 if(idx == 9){
                    return  solve(row+1 , 0 , board , rows , cols , boxes);
                 }

                 if(row == 9){
                    return true;
                 }

                 if(Character.isDigit(board[row][idx])){
                   return solve(row,idx+1,board,rows,cols,boxes);
                 }

                 int box = (row/3)*3 +(idx/3);

                 for(int i =1 ; i <= 9; i ++){
                     if(rows[row][i] || cols[idx][i]|| boxes[box][i]){
                           continue;
                     }
                     rows[row][i] = cols[idx][i] = boxes[box][i]= true;
                     board[row][idx] = (char) (i + '0');
                    if(solve(row,idx+1,board,rows,cols,boxes)){
                        return true;
                    }
                    rows[row][i] = cols[idx][i] = boxes[box][i]= false;
                    board[row][idx] = '.';



                 }
                 return false;

    }
}