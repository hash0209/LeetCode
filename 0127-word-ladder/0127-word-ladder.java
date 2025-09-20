class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> q = new LinkedList<>();

        q.add(beginWord);

        Set<String> set = new HashSet<>(wordList);
       
     
        int level = 1;

        while (!q.isEmpty()) {
            
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String s = q.poll();
                if(s.equals(endWord)){
                 

                    return level;
                }

                char[] ch = s.toCharArray();
                  

                
                for (int i = 0; i < s.length(); i++) {

                    char original = ch[i];
                   
                    for (char c = 'a'; c <= 'z'; c++) {
                        ch[i] = c;
                        String t = new String(ch);
                      
                        if (set.contains(t)) {
                           
                            q.add(t);
                            set.remove(t);
                        }
                    }
                    ch[i]=original;
                }
            }
            level++;
        }

        return 0;

    }
}