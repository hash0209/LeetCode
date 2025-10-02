class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if (i >= k - 1) {
                list.add(nums[dq.peekFirst()]);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;

    }
}