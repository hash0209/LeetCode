class Solution {
    public int maximalRectangle(char[][] matrix) {

        int[] temp = new int[matrix[0].length];

        int maxArea = 0;

        for (int i = 0; i < matrix.length; i++) {
            int[] temp2 = new int[matrix[0].length];

            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    temp2[j] = 0;
                } else {
                    temp2[j] = (matrix[i][j] - '0') + temp[j];
                }
            }

          

            Stack<Integer> s = new Stack<>();

            

            for (int k = 0; k < temp2.length; k++) {
                //calculate pse

                int pse = 0;

                while (!s.isEmpty() && temp2[s.peek()] >= temp2[k]) {
                    int el = s.pop();

                    int nse = k;
                    if (s.isEmpty()) {
                        pse = -1;
                    } else {
                        pse = s.peek();
                    }

                    int area = (nse - pse - 1) * temp2[el];

                    maxArea = Math.max(area, maxArea);
                }

                s.push(k);

            }

            int nse = temp2.length;
            int pse = 0;

            while (!s.isEmpty()) {

                int el = s.pop();

               
                if (s.isEmpty()) {
                    pse = -1;
                } else {
                    pse = s.peek();
                }

                int area = (nse - pse - 1) * temp2[el];

                maxArea = Math.max(area, maxArea);

            }

            temp = temp2;
        }

        return maxArea;
    }
}