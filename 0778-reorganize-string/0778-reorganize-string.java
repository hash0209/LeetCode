class Solution {
    public String reorganizeString(String s) {

        char[] ch = s.toCharArray();
        int n = ch.length;

        int[] freq =new int[26];

        for(int i = 0; i < ch.length ; i++){
               freq[ch[i]-'a'] = freq[ch[i]-'a']+1;

               if(freq[ch[i]-'a']> (n+1)/2){
                return "";
               }
        }

        PriorityQueue<CharCount> maxheap = new PriorityQueue<>((a,b) -> b.freq-a.freq);

        for(int i = 0; i< 26 ; i++){
              if(freq[i] > 0){
                char c = (char)(i +  'a');
                
                maxheap.add(new CharCount(c , freq[i] ));
              }
        }

        StringBuilder sb = new StringBuilder();

        while(maxheap.size()>=2){
            CharCount first = maxheap.poll();
            CharCount second = maxheap.poll();
            System.out.println(first.ch);
            System.out.println(second.ch);

            sb.append(first.ch);
            sb.append(second.ch);

            first.freq--;
            second.freq--;

            if(first.freq > 0){
                maxheap.add(first);
            }
            if(second.freq > 0){
                maxheap.add(second);
            }
        }

        while(!maxheap.isEmpty()){
            sb.append(maxheap.poll().ch);
        }

        return sb.toString();







        
    }
}

class CharCount{
    char ch ;
    int freq ;

   public   CharCount(char ch , int freq){
        this.ch = ch;
        this.freq = freq;
    }
}