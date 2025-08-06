class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> curr =  new ArrayList<>();

        List<String> result = new ArrayList<>();

        int size =0;

        for(String word : words){

            if(size+ word.length()+ curr.size() > maxWidth){
               String justifiedline =  justify(curr,maxWidth , false);
               result.add(justifiedline);
               curr.clear();
               size=0;

            }
            size+=word.length();
            curr.add(word);
        }
        String justifiedline =  justify(curr,maxWidth , true);
        result.add(justifiedline);
        return result;


    }
    public String justify(List<String> curr , int maxwidth , boolean islast){

        String str = String.join(" ",curr);
        int emptySpaces = maxwidth - str.length();
        StringBuilder sb = new StringBuilder();

        if(curr.size() ==1 || (islast)){
            sb.append(str);
            for(int i = 0; i< emptySpaces ; i++){
                sb.append(" ");
            }
            return sb.toString();
        }


        int gaps = emptySpaces/(curr.size()-1);
        int extra = emptySpaces%(curr.size()-1);

        for(int i = 0; i < curr.size() ;i++){
            sb.append(curr.get(i));

            if(i < curr.size()-1){
                 for(int  g = 0; g <= gaps ; g++){
                    sb.append(" ");
                 }
            

            if(extra > 0){
                sb.append(" ");
                extra--;
            }
        }


        
    }
    return sb.toString();


}
}