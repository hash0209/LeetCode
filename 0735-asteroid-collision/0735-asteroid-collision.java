class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<Integer>();

        for (int i = asteroids.length - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                st.push(asteroids[i]);
            }

            else {
                //int x = st.peek();

                if (asteroids[i] < 0) {
                    st.push(asteroids[i]);
                } else {
                    int el = asteroids[i];
                    while (!st.isEmpty()) {
                        if (st.peek() > 0) {
                            //st.push(el);
                            break;
                        } else {
                            if (el < 0) {
                                //  st.push(el);
                                break;
                            } else {
                                int p = st.pop();
                                int abp = Math.abs(p);
                                if (abp > el) {
                                    el = p;
                                } else if (abp == el) {
                                    el = 0;
                                    break;
                                }

                            }

                        }
                    }

                    if (el != 0) {
                        st.push(el);
                    }

                }
            }

            /*   if((x > 0 && asteroids[i] > 0) || (x < 0 && asteroids[i] < 0) ){
                   st.push(asteroids[i]);
               }
            
              else if(asteroids[i] > 0 && x < 0){
                   st.pop();
                   int abX = Math.abs(x);
                   if(asteroids[i] > abX){
                       st.push(asteroids[i]);
                   }
                   else if(asteroids[i] < abX){
                       st.push(x);
                   }
                   
            
               } */
            //    }
        }

        if (st.isEmpty()) {
            return new int[0];
        } else {
            int[] ans = new int[st.size()];
            int idx = 0;

            while (!st.isEmpty()) {
                ans[idx] = st.pop();
                idx++;
            }

            return ans;
        }

    }
}