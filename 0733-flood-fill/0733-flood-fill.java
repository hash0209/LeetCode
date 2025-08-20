class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = image[i][j];
            }
        }
        if (image[sr][sc] == color) {
            return res;
        }

        int originalcolor = image[sr][sc];

        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        res[sr][sc] = color;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        while (!q.isEmpty()) {

            Pair curr = q.poll();
            int i = curr.i;
            int j = curr.j;
            for (int d = 0; d < dir.length; d++) {
                int ni = i + dir[d][0];
                int nj = j + dir[d][1];

                if (ni >= 0 && nj >= 0 && ni < m && nj < n) {
                    if (image[ni][nj] == originalcolor && res[ni][nj] != color) {
                        res[ni][nj] = color;
                        q.add(new Pair(ni, nj));
                    }
                }
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