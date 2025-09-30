class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1); // 0-indexed
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left]; // only one element

        int pivotIndex = left + (int)(Math.random() * (right - left + 1));
        int pivot = nums[pivotIndex];
        swap(pivotIndex, right, nums); // move pivot to end

        int pIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > pivot) { // larger elements to left
                swap(i, pIndex, nums);
                pIndex++;
            }
        }
        swap(pIndex, right, nums); // pivot in correct place

        if (pIndex == k) return nums[pIndex];
        else if (pIndex > k) return quickSelect(nums, left, pIndex - 1, k);
        else return quickSelect(nums, pIndex + 1, right, k);
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}