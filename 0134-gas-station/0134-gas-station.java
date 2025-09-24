class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int total = 0;
        int tank = 0;

        int startIdx =0;

        for(int i =0; i < gas.length ; i++){
              total += gas[i]-cost[i];
              tank += gas[i]-cost[i];

             if(tank < 0){
                startIdx = i+1;
                tank =0;

             }
        }

        return (total >= 0) ? startIdx : -1;
    
        
    }
}