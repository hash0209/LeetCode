class Solution {
    // Function to find all possible paths
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        maze[0][0] = -1;
        ArrayList<String> ans = find(maze , 0 , 0 ,"");
        maze[0][0] =1;
        return ans;
        
        
    }
    
    public ArrayList<String> find(int[][] maze , int r , int c , String move){
        
        ArrayList<String> ans = new ArrayList<String>();
        if(r == maze.length-1 && c == maze[0].length-1){
             ans.add(move);
             return ans;
        }
        
        if(check(maze,r+1,c)){
            maze[r+1][c] = -1;
            List<String> down = find(maze , r+1,c,"D");
              maze[r+1][c] = 1;
            for(int i =0; i < down.size();i ++){
                down.set(i,move.concat(down.get(i)));
            }
            ans.addAll(down);
        }
        
        if(check(maze,r,c-1)){
            maze[r][c-1] = -1;
             List<String> left = find(maze,r,c-1,"L");
             maze[r][c-1] = 1;
             for(int i =0; i < left.size();i ++){
                left.set(i,move.concat(left.get(i)));
            }
            ans.addAll(left);
        }
        
        if(check(maze,r,c+1)){
            maze[r][c+1] = -1;
             List<String> right = find(maze,r,c+1,"R");
             maze[r][c+1] = 1;
             for(int i =0; i < right.size();i ++){
                right.set(i,move.concat(right.get(i)));
            }
            ans.addAll(right);
        }
        if(check(maze,r-1,c)){
            maze[r-1][c] = -1;
             List<String> up = find(maze,r-1,c,"U");
             maze[r-1][c] =1;
             for(int i =0; i < up.size();i ++){
                up.set(i,move.concat(up.get(i)));
            }
            ans.addAll(up);
        }
        
        return ans;
    }
    
    
    public boolean check(int[][] maze , int r , int c ){
        if(r < 0 || c< 0  || r > maze.length-1 || c> maze.length-1){
            return false;
        }
        
        if(maze[r][c] == 0 || maze[r][c] == -1){
            return false;
        }
        return true;
    }
}