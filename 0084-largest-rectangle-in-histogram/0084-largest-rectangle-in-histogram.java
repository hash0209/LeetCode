class Solution {
    public int largestRectangleArea(int[] heights) {

          Stack<Integer> s = new Stack<>();

          int[] prev = new int[heights.length];

          int[] next = new int[heights.length];



          for(int i=0; i < heights.length;i++){
            while(!s.isEmpty()&& heights[s.peek()] >= heights[i]){
                s.pop();
            }

            if(s.isEmpty()){
                prev[i] = -1;
            }
            else{
                prev[i] = s.peek();
            }

            s.push(i);
          }


          s =new Stack<Integer>();




           for(int i=heights.length-1; i >=0;i--){
            while(!s.isEmpty()&& heights[s.peek()] >= heights[i]){
                s.pop();
            }

            if(s.isEmpty()){
                next[i] = heights.length;
            }
            else{
                next[i] = s.peek();
            }

            s.push(i);
          }


          int total =0;


          for(int i =0; i < heights.length; i ++){
            int sum = (next[i] - prev[i] - 1)* heights[i];

            total = Math.max(total,sum);
          }

          return total;





        
    }
}