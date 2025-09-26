class Solution {
    public String reverseWords(String s) {
          s=s.trim();
          String[] str = s.split(" ");

          List<String> list = new ArrayList<>();
          for(int i =0; i < str.length;i++){
              if(!str[i].isEmpty()){
                  list.add(str[i]);
              }
              
          }

          System.out.println(list.size());

         int l =0;
         int r = list.size()-1;

         while(l < r){
            String temp = list.get(r);
            list.set(r,list.get(l));
            list.set(l,temp);
           
            l++;
            r--;
         }

         StringBuilder sb= new StringBuilder();
         for(int i =0; i < list.size();i++){
            if(i !=0){
                sb.append(" ");
            }
            sb.append(list.get(i));
         }
         return sb.toString();





          
    }
}