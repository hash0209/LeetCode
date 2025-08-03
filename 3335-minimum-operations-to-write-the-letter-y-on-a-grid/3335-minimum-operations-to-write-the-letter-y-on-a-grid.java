class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {

        
        boolean[][] visited ;
        int count = Integer.MAX_VALUE;

        for(int i = 0; i <= 2 ; i ++){
            visited = new boolean[grid.length][grid.length];
            int countY = setY(grid , i , visited);
            int countRest = Integer.MAX_VALUE;

            for(int j = 0; j <= 2; j ++){
                if(j != i){
                     countRest = Math.min(countRest,setRest(grid , j , visited));
                }
            }

            count = Math.min(count , countY+ countRest);




        }
        return count ;
        
    }


    public int setY(int [][] grid , int num , boolean[][] visited){

        int count = 0;

        int centre = grid.length/2 ;

        for(int i = 0; i <= centre ; i++){
            visited[i][i] =true;


            if(grid[i][i] != num ){
                 
                 count++;
            }


        }

        int row1 = 0;

        for(int i = grid.length-1 ; i > centre ; i--){
            visited[row1][i] =true;


            if(grid[row1][i] != num ){
                 
                 count++;
            }
            row1++;

        }


        for(int row = centre+1 ; row < grid.length ; row++){

            visited[row][centre] =true;

            if(grid[row][centre] !=num){
               
                count++;
            }
        }
        return count ;
    }

      public int setRest(int [][] grid , int num , boolean[][] visited){
        int count = 0;

        for(int i  =0; i < grid.length ; i++){
            for(int j = 0 ; j < grid.length ; j++){
                if( !visited[i][j] && grid[i][j]!=num){
                    count++;
                }
            }
        }
        return count ;
    }
}