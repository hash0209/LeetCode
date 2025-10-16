class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

            int len = nums1.length > nums2.length ? nums1.length : nums2.length;
            int[] res = new int[len];

            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int left =0; 
            int right =0;

            int idx =0;

            while(left < nums1.length &&  right < nums2.length){
                    if(nums1[left] == nums2[right]){
                        
                        res[idx] = nums1[left];
                       
                        left++;
                        while(left  < nums1.length && nums1[left]==res[idx]){
                            left++;
                        }
                        right++;
                        while(right  < nums2.length && nums2[right]==res[idx]){
                            right++;
                        }
                        idx++;
                        
                    }
                    else if(nums1[left] < nums2[right]){

                        left++;
                        

                    }
                    else{
                        right++;
                       

                    }
            }
         
           
            return Arrays.copyOfRange(res,0,idx);
        
    }
}