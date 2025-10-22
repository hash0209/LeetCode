class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> set = new HashSet<>();

        for (int i = 0; i < deadends.length; i++) {
            set.add(deadends[i]);
        }

        if(set.contains("0000")){
            return -1;
        }

        if("0000".equals(target)){
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.add("0000");
       

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
                    String s = new String(ch);
                  
                  

                    if (!set.contains(s)) {
                        set.add(s);
                        q.add(s);
                    }

                    int num2 = (num - 1 + 10) % 10;
                    ch[c] = (char) (num2 + '0');
                    s = new String(ch);

                   

                    if (!set.contains(s)) {
                        set.add(s);
                        q.add(s);
                    }
                  

                    ch[c] = orig;

                }
               

            }
            moves++;

        }

        return -1;

    }
}