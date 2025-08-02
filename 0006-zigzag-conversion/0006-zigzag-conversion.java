class Solution {
    public String convert(String s, int numRows) {

        if(numRows ==1){
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();
        
        for(int i =0; i < numRows ; i++){
            list.add(new StringBuilder());
        }

        int row =0;
        int direction = 1;

        for(int i = 0; i < s.length() ;i++){
            list.get(row).append(s.charAt(i));
            if(row == 0){
                direction =1 ;
            }
            if(row == numRows-1){
                direction = -1;
            }

            row = row+direction;
           
        }

      StringBuilder ans1 =new StringBuilder();

        for(int i =0 ; i < list.size();i++){
            ans1.append(list.get(i));
        }

        return ans1.toString();



        
    }
}