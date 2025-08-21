import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;

        // Step 1: calculate total sum
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // Step 2: split array into two halves
        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, nums.length);

        // Step 3: generate all subset sums grouped by size
        List<List<Integer>> leftSums = getSubsetSums(left);
        List<List<Integer>> rightSums = getSubsetSums(right);

        // Step 4: sort each list to use two pointers
        for (List<Integer> list : leftSums) Collections.sort(list);
        for (List<Integer> list : rightSums) Collections.sort(list);

        int ans = Integer.MAX_VALUE;

        // Step 5: iterate over all possible splits
        for (int k = 0; k <= n; k++) {
            List<Integer> L = leftSums.get(k);       // choose k elements from left
            List<Integer> R = rightSums.get(n - k);  // choose n-k elements from right

            int i = 0;
            int j = R.size() - 1;

            // two pointer scan
            while (i < L.size() && j >= 0) {
                int sum = L.get(i) + R.get(j);
                int diff = Math.abs(totalSum - 2 * sum);
                ans = Math.min(ans, diff);

                // dry run example:
                // totalSum = 22, want sum close to 11
                // if sum > 11 -> decrease sum by moving j--
                // else -> increase sum by moving i++
                if (sum > totalSum / 2) {
                    j--;
                } else {
                    i++;
                }
            }
        }

        return ans;
    }

    // Generate all subset sums grouped by number of elements chosen
    private List<List<Integer>> getSubsetSums(int[] arr) {
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) result.add(new ArrayList<>());
        generate(arr, 0, 0, 0, result);
        return result;
    }

    private void generate(int[] arr, int idx, int count, int sum, List<List<Integer>> res) {
        if (idx == arr.length) {
            // Example dry run for arr=[3,5]:
            // subset {} -> count=0, sum=0
            // subset {3} -> count=1, sum=3
            // subset {5} -> count=1, sum=5
            // subset {3,5} -> count=2, sum=8
            res.get(count).add(sum);
            return;
        }
        // include arr[idx]
        generate(arr, idx + 1, count + 1, sum + arr[idx], res);
        // skip arr[idx]
        generate(arr, idx + 1, count, sum, res);
    }
}
