class Solution {
    public int maximalRectangle(char[][] matrix) {

      
        

        int[] temp = new int[matrix[0].length];

        int maxArea =0;

        for (int i = 0; i < matrix.length ; i++){
            int[] temp2 = new int[matrix[0].length];

            for(int j =0; j < matrix[0].length ;j++){
                if(matrix[i][j] == '0'){
                     temp2[j] = 0;
                }
                else{
                    temp2[j] = (matrix[i][j] -'0') + temp[j];
                }
            }
        



        int[] nse = new int[matrix[0].length];


        Stack<Integer> s = new Stack<>();

        for(int k = temp2.length-1; k >=0 ;k--){
            while(!s.isEmpty() && temp2[s.peek()] >= temp2[k]  ){
                s.pop();
            }

            if(s.isEmpty()){
                nse[k] =temp2.length;
            }
            else{
                nse[k] = s.peek();
            }
            s.push(k);
        }



        s.clear();

        for(int k=0 ; k < temp2.length ;k++){
            //calculate pse

            int pse = 0;

            while(!s.isEmpty() && temp2[s.peek()] >= temp2[k]){
                s.pop();
            }

            if(s.isEmpty()){
                pse = -1;
            }
            else{

                pse = s.peek();
            }
            s.push(k);


            int area = (nse[k] - pse-1)*temp2[k];

            maxArea =Math.max(area,maxArea);


        }

        temp =temp2;
    } 

    return maxArea;
}}