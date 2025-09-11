class Solution {
    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();
        if(numRows == 1|| s.length() <= numRows){
             return s;
        }
        for(int i =0; i < numRows ; i++){   
           
            list.add(new StringBuilder(""));
        }

        int row=0;
        int d =1;


        for(int i =0; i < s.length() ; i++){
            list.get(row).append(s.charAt(i));
           
            if(row == numRows-1){
                d =-1;
            }
            if(row == 0){
                d = 1;
            }
             row=row+d;
        }

        StringBuilder sb = new StringBuilder();
        for(StringBuilder sb1 : list){
           sb.append(sb1);
        }
        return sb.toString();


    }
}