class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){
            return intersection(nums2,nums1);
        }

        Set<Integer> list = new HashSet<>();

        Set<Integer> set = new HashSet<>();

        for(Integer i : nums2){
            set.add(i);
        }

        for(Integer i : nums1){
            if(set.contains(i)){
                list.add(i);
            }
        }


        int[] res = new int[list.size()];
        int idx =0;

        for(Integer i : list){
              res[idx] = i;
              idx++;
        }

        return res;
        
    }
}