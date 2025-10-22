class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> set = new HashSet<>();
        String begin="0000";
       
      
        for (int i = 0; i < deadends.length; i++) {
            set.add(deadends[i]);
        }
          if(set.contains(begin)){
            return -1;
        }

       

        

        Queue<String> q = new LinkedList<>();
        q.add(begin);
        Set<String> visited = new HashSet<>();
        visited.add(begin);


       

        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();
        

            for (int j = 0; j < size; j++) {
                String code = q.poll();
                if(code.equals(target)){
                    return moves;
                }

                char[] ch = code.toCharArray();

                for (int c = 0; c < ch.length; c++) {
                    char orig = ch[c];

                    int num = ch[c] - '0';
                    int num1 = (num + 1) % 10;
                    ch[c] = (char) (num1 + '0');
                    String up = new String(ch);
                  
                  

                    if (!set.contains(up) && !visited.contains(up)) {
                        visited.add(up);
                        q.add(up);
                    }

                    int num2 = (num - 1 + 10) % 10;
                    ch[c] = (char) (num2 + '0');
                    String down = new String(ch);

                   

                     if (!set.contains(down) && !visited.contains(down)) {
                        visited.add(down);
                        q.add(down);
                    }

                  

                    ch[c] = orig;

                }
               

            }
            moves++;

        }

        return -1;

    }
}