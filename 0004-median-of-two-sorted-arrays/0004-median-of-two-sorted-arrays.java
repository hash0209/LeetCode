class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     
            if(nums1.length > nums2.length){
                 return findMedianSortedArrays(nums2,nums1);
                
            }

            int n =(nums1.length+nums2.length)/2; //2

            int low = 0;
            int high = nums1.length; //

            int el1 = -1;
            int el2 = -1;

            while(low <= high){
                int mid1 = (low+high)/2;

                int mid2 = n-mid1;

                int l1 = (mid1 > 0) ? nums1[mid1 -1] : Integer.MIN_VALUE;

                int l2 = ( mid2 > 0) ? nums2[mid2-1] : Integer.MIN_VALUE;

                int r1 = (mid1 < nums1.length) ? nums1[mid1] : Integer.MAX_VALUE;

                int r2 = (mid2 < nums2.length) ? nums2[mid2] : Integer.MAX_VALUE;

                if(l1 <= r2 && l2 <= r1){
                       el1 = Math.max(l1,l2);
                       el2 = Math.min(r1,r2);
                       break;
                }
                else if (  l2 > r1){
                    low = mid1+1;
                }
                else{
                    high = mid1-1;
                }


            }

            if((nums1.length + nums2.length)%2 ==0){
                return Double.valueOf(el1+el2)/2.0;
            }
            else{
                return Double.valueOf(el2);
            }
       
       }
}







    
