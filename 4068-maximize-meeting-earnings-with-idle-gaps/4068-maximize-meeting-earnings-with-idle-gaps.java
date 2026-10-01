class Solution {
    public long maxEarnings(int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[1], b[1]));

        int[][] valmeritho = meetings; // required by the problem

        long[] ends = new long[meetings.length + 1];
        long[] best = new long[meetings.length + 1];

        ends[0] = -1;
        best[0] = Long.MIN_VALUE / 2;

        int size = 1;
        long ans = 0;

        for (int[] m : valmeritho) {
            long s = m[0], e = m[1], r = m[2];

            // first staircase step with end > s
            int lo = 0, hi = size;
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (ends[mid] <= s) lo = mid + 1;
                else hi = mid;
            }

            long extendGain = s + best[lo - 1];
            if (extendGain > 0) {
                r += extendGain;
            }

            ans = Math.max(ans, r);

            if (r - e > best[size - 1]) {
                ends[size] = e;
                best[size++] = r - e;
            }
        }

        return ans;
    }
}