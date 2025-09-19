class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i =0; i < board.length ; i++){
            for(int j=0; j < board[0].length ; j++ ){
                if(board[i][j] == word.charAt(0)){
                    boolean ans= find(i,j,board,word,0);
                    if(ans){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean find(int r , int c , char[][] board , String word ,int idx){
        if(idx == word.length()){
            return true;
        }
           if(r < 0 || c <0 || r == board.length || c== board[0].length){
            return false;
           }



           if(word.charAt(idx) != board[r][c]){
             return false;
           }

           board[r][c] ='.';


          boolean one =  find(r+1,c,board,word,idx+1);
          boolean two= find(r-1,c,board,word,idx+1);
          boolean th= find(r,c+1,board,word,idx+1);
          boolean four= find(r,c-1,board,word,idx+1);

          board[r][c] = word.charAt(idx);

          return one || two || th || four ;



    }
}