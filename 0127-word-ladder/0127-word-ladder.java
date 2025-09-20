class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> q = new LinkedList<>();

        q.add(beginWord);

        Set<String> set = new HashSet<>(wordList);
        System.out.println(set.size());
     
        int level = 1;

        while (!q.isEmpty()) {
            
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String s = q.poll();
                if(s.equals(endWord)){
                 

                    return level;
                }

                
                for (int i = 0; i < s.length(); i++) {
                    char[] ch = s.toCharArray();
                  
                    for (char c = 'a'; c <= 'z'; c++) {
                        ch[i] = c;
                        String t = new String(ch);
                      
                        if (set.contains(t)) {
                           
                            q.add(t);
                            set.remove(t);
                        }
                    }
                }
            }
            level++;
        }

        return 0;

    }
}