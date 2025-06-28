class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int l =0; 
        int r = cardPoints.length -k;



        int total =0;

        for(int i =r ; i < cardPoints.length ;i++){
             total=total +cardPoints[i];
        }

        int maxtotal = total;

        while(l < k){
            total = total - cardPoints[r] + cardPoints[l];
            maxtotal = Math.max(maxtotal,total);
            r++;
            l++;
        }

        return maxtotal;


    }
}