class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] res = new int[m][n];

        for(int i =0; i < m ; i++){
            for(int j =0; j < n ; j++){
                res[i][j] = image[i][j];
            }
        }
        if (image[sr][sc] == color) {
            return res;
        }
        
        int originalcolor = image[sr][sc];
       
      
        res[sr][sc] = color;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        while (!q.isEmpty()) {
           
                Pair curr = q.poll();
                int i = curr.i;
                int j = curr.j;
                if (i - 1 >= 0 &&  image[i - 1][j] == originalcolor && res[i - 1][j] != color) {
                    res[i - 1][j] = color;
                   
                    q.add(new Pair(i - 1, j));
                }
                if (i + 1 < m &&   image[i + 1][j] == originalcolor && res[i + 1][j] != color) {
                    res[i + 1][j] = color;
                  
                    q.add(new Pair(i + 1, j));
                }
                if (j - 1 >= 0 &&  image[i][j - 1] == originalcolor && res[i][j - 1] != color) {
                    res[i][j - 1] = color;
                   
                    q.add(new Pair(i, j - 1));
                }
                if (j + 1 < n &&   image[i][j + 1] == originalcolor && res[i][j + 1] != color) {
                    res[i][j + 1] = color;
                   
                    q.add(new Pair(i, j + 1));
                }
            

        }
        return res;

    }
}

class Pair {
    int i;
    int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

}