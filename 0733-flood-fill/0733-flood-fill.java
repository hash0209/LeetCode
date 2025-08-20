class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
           return image;
          }
        int m = image.length;
        int n = image[0].length;
        int originalcolor = image[sr][sc];
        boolean[][] seen = new boolean[image.length][image[0].length];
        seen[sr][sc] = true;
        image[sr][sc] = color;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                Pair curr = q.poll();
                int i = curr.i;
                int j = curr.j;
                if (i - 1 >= 0 && !seen[i - 1][j] && image[i - 1][j] == originalcolor) {
                    image[i - 1][j] = color;
                    seen[i - 1][j] = true;
                    q.add(new Pair(i - 1, j));
                }
                if (i + 1 < m && !seen[i + 1][j] && image[i + 1][j] == originalcolor) {
                    image[i + 1][j] = color;
                    seen[i + 1][j] = true;
                    q.add(new Pair(i + 1, j));
                }
                if (j - 1 >= 0 && !seen[i][j - 1] && image[i][j - 1] == originalcolor) {
                    image[i][j - 1] = color;
                    seen[i][j - 1] = true;
                    q.add(new Pair(i, j - 1));
                }
                if (j + 1 < n && !seen[i][j + 1] && image[i][j + 1] == originalcolor) {
                    image[i][j + 1] = color;
                    seen[i][j + 1] = true;
                    q.add(new Pair(i, j + 1));
                }
            }

        }
        return image;

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