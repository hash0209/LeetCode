class Solution {
    public int calculate(String s) {

        Stack<Integer> st = new Stack<>();
         s =s.trim();

        char[] c = s.toCharArray();
        int num =0;
        char prevSign = '+';
      
        System.out.println(c.length);

        for(int i =0; i < c.length ; i++){
          
            if(c[i] ==' ' ){
               
                continue;
            }
              if(Character.isDigit(c[i])){
                num = num*10+(c[i]-'0');
              }
              if(!Character.isDigit(c[i])||i==c.length-1){
                  if(prevSign=='+'){
                    st.push(num);
                  }
                  if(prevSign=='-'){
                    st.push(-num);
                  }
                  if(prevSign=='/'){
                    
                    st.push(st.pop()/num);
                  }
                  if(prevSign=='*'){
                    st.push(st.pop()*num);
                  }

                  prevSign = c[i];
                  num=0;
              }
        }

        int res =0;

        while(!st.isEmpty()){
            res+=st.pop();
        }

        return res ;

        
    }
}