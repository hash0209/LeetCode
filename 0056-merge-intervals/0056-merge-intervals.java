class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> res = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            if (s > end) {
                ArrayList<Integer> l = new ArrayList<>();

                l.add(start);
                l.add(end);

                res.add(l);

                start = s;
                end = e;

            } else {
                if (e > end) {
                    end = e;
                }
            }

        }

        ArrayList<Integer> l = new ArrayList<>();
        l.add(start);
        l.add(end);
        res.add(l);

        int[][] ans = new int[res.size()][2];

        for (int i = 0; i < res.size(); i++) {
            ans[i][0] = res.get(i).get(0);
            ans[i][1] = res.get(i).get(1);
        }

        return ans;

    }
}