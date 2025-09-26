class Solution {
    public String reverseWords(String s) {
          s=s.trim();
          String[] str = s.split("\\s+");

        //  List<String> list = new ArrayList<>();
        //  for(int i =0; i < str.length;i++){
        //      if(!str[i].isEmpty()){
        //          list.add(str[i]);
//}
              
     //     }

         

         StringBuilder sb= new StringBuilder();
        // for(int i =list.size()-1; i>= 0;i--){
        //    if(i !=list.size()-1){
        //        sb.append(" ");
        //    }
        //    sb.append(list.get(i));
       //  }

       for(int i = str.length-1; i >= 0 ;i--){
           if(i!=str.length-1){
            sb.append(" ");
           }
           sb.append(str[i]);
       }
         return sb.toString();





          
    }
}