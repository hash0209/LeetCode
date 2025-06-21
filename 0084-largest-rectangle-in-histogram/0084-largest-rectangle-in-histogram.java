class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {

            //pse
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int el = st.pop();

                int nse = i;
                int pse = 0;
                if (!st.isEmpty()) {
                    pse = st.peek();
                } else {
                    pse = -1;
                }

                int area = (nse - pse - 1) * heights[el];
                maxArea = Math.max(area, maxArea);
                
            }
            st.push(i);
        }

        int nse = heights.length;

        while (!st.isEmpty()) {
            int el = st.pop();
            int pse = 0;
            if (!st.isEmpty()) {
                pse = st.peek();
            } else {
                pse = -1;
            }
            int area = (nse - pse - 1) * heights[el];
            maxArea = Math.max(area, maxArea);
        }


        return maxArea;

    }
}