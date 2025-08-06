class Solution {
    public boolean exist(char[][] board, String word) {

        for(int i =0; i< board.length ; i++){
            for(int j =0; j < board[0].length ; j++){
                if(board[i][j] == word.charAt(0)){
                     if(find(i,j,0,word,board)){
                        return true;
                     }
                }
            }
        }

        return false;


        
    }

    public boolean find(int row , int col , int idx , String word , char[][] board){

        if(idx == word.length()){
            return true ;
        }

        if(row < 0 || col < 0 || row == board.length || col ==board[0].length){
            return false;
        }

        if(board[row][col] == word.charAt(idx)){

            board[row][col] ='.';

            boolean up = find(row+1,col,idx+1,word,board);
            boolean down = find(row-1,col,idx+1,word,board);
            boolean right = find(row,col+1,idx+1,word,board);
            boolean left = find(row,col-1,idx+1,word,board);

            board[row][col] =word.charAt(idx);

            return (up || down || right || left);

        }

        return false;
    }
}