class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        Map<String,Integer> freqMap = new HashMap<>();
        for(String word : words){
            freqMap.put(word , freqMap.getOrDefault(word,0)+1);
        }

        for(int offset=0; offset < wordLen ; offset++){
            int left =offset;
            int right = offset;

            Map<String,Integer> windowMap = new HashMap<>();

            while(right + wordLen <= s.length()){
               String rightWord = s.substring(right,right+wordLen);
               right=right+wordLen;
               
               

                if(freqMap.containsKey(rightWord)){
                    windowMap.put(rightWord , windowMap.getOrDefault(rightWord,0)+1);
                

                while(windowMap.get(rightWord) > freqMap.get(rightWord)){
                       String leftWord = s.substring(left,left+wordLen);
                       windowMap.put(leftWord,windowMap.get(leftWord)-1);
                       left=left+wordLen;
                }
               

                if(right-left == totalLen){
                    ans.add(left);
                }
                }
                else{
                    windowMap.clear();
                    left=right;
                }
            }



            
        }
        return ans;
    }
}