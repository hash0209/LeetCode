class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     
            if(nums1.length > nums2.length){
                 return findMedianSortedArrays(nums2,nums1);
                
            }

            int total = nums1.length+nums2.length;

            int n =(total)/2; //2

            int low = 0;
            int high = nums1.length; //

            

            while(low <= high){
                int mid1 = (low+high)/2;

                int mid2 = n-mid1;

                int l1 = (mid1 > 0) ? nums1[mid1 -1] : Integer.MIN_VALUE;

                int l2 = ( mid2 > 0) ? nums2[mid2-1] : Integer.MIN_VALUE;

                int r1 = (mid1 < nums1.length) ? nums1[mid1] : Integer.MAX_VALUE;

                int r2 = (mid2 < nums2.length) ? nums2[mid2] : Integer.MAX_VALUE;

                if(l1 <= r2 && l2 <= r1){
                    if(total % 2 == 0){
                      return (double) (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                    }
                    else{
                     return (double)  (Math.min(r1,r2));
                    }
                }
                else if (  l2 > r1){
                    low = mid1+1;
                }
                else{
                    high = mid1-1;
                }


            }
            return 0.0;

            
       }
}







    
