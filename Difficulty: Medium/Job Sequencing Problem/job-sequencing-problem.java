class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        ArrayList<Job> list = new ArrayList<>();
        
        int idx =0;
        while(idx < profit.length){
            Job j = new Job(deadline[idx],profit[idx]);
            list.add(j);
            idx++;
        }
        
        int count =0;
        list.sort(Comparator.comparing(Job::getP).reversed());
        
        int[] days = new int[profit.length+1];
        
        for (Job j : list){
            int deadline1 = j.getD();
           
           
                while(deadline1 > 0){
                    if(days[deadline1] == 0){
                       count++;
                       days[deadline1] = j.getP(); 
                       break;
                    }
                    deadline1--;
                }
            }
            
            
            int sum =0;
            
            for(Integer profit1 : days){
                sum+=profit1;
            }
            
            
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(count);
            ans.add(sum);
            
            return ans;
        }
        
        
        
    }
    
    
    



class Job{
    private int d ; 
    private int p;
    
    public Job(int d , int p){
        this.d = d ; 
        this.p = p;
}


    public int getD(){
        return d;
    }
    
    public int getP(){
        return p;
    }
}