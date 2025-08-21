import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;

        // Step 1: calculate total sum of all numbers
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // Step 2: split nums into two halves
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) left[i] = nums[i];
        for (int i = 0; i < n; i++) right[i] = nums[i + n];

        // Step 3: generate all subset sums from each half
        // Group them by number of elements chosen
        List<List<Integer>> leftSums = getSubsetSums(left);
        List<List<Integer>> rightSums = getSubsetSums(right);

        // Step 4: sort right half sums for binary search
        for (List<Integer> list : rightSums) {
            list.sort((a, b) -> a - b);
        }

        int ans = Integer.MAX_VALUE;

        // Step 5: Try all splits of choosing k from left and (n-k) from right
        for (int k = 0; k <= n; k++) {
            List<Integer> L = leftSums.get(k);
            List<Integer> R = rightSums.get(n - k);

            for (int lSum : L) {
                // target is how much we ideally want from right side
                int target = totalSum / 2 - lSum;

                // Binary search: find smallest element >= target
                int idx = binarySearch(R, target);

                // Check candidate at idx
                if (idx < R.size()) {
                    int pick = lSum + R.get(idx);
                    ans = Math.min(ans, Math.abs(totalSum - 2 * pick));
                }
                // Check candidate just before idx (closest smaller one)
                if (idx > 0) {
                    int pick = lSum + R.get(idx - 1);
                    ans = Math.min(ans, Math.abs(totalSum - 2 * pick));
                }
            }
        }
        return ans;
    }

    // Generate all subset sums grouped by size
    private List<List<Integer>> getSubsetSums(int[] arr) {
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) result.add(new ArrayList<>());
        generate(arr, 0, 0, 0, result);
        return result;
    }

    // Recursive function to generate subsets
    private void generate(int[] arr, int idx, int count, int sum, List<List<Integer>> res) {
        if (idx == arr.length) {
            // dry run example: if arr = [3,5], 
            // subset {} -> count=0, sum=0
            // subset {3} -> count=1, sum=3
            // subset {5} -> count=1, sum=5
            // subset {3,5} -> count=2, sum=8
            res.get(count).add(sum);
            return;
        }
        // choose arr[idx]
        generate(arr, idx + 1, count + 1, sum + arr[idx], res);

        // skip arr[idx]
        generate(arr, idx + 1, count, sum, res);
    }

    // Binary search: find index of smallest element >= target
    private int binarySearch(List<Integer> arr, int target) {
        int low = 0, high = arr.size() - 1;
        int ans = arr.size(); // default: nothing >= target
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // dry run idea:
            // arr = [2,5,9], target=6
            // mid=1 -> arr[1]=5 < 6 -> move right
            // mid=2 -> arr[2]=9 >= 6 -> ans=2, move left
            // final ans=2 (index of 9, first >= target)

            if (arr.get(mid) >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
