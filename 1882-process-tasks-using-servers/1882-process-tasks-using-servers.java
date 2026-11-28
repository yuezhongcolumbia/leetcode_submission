class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        // [weight, index]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // [freeTime, weight, index]
        PriorityQueue<long[]> q = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        for (int i = 0; i < servers.length; i++) {
            pq.offer(new int[]{servers[i], i});
        }

        long time = 0;
        int[] res = new int[tasks.length];

        for (int i = 0; i < tasks.length; i++) {

            time = Math.max(i, time);

            // Release available servers
            while (!q.isEmpty() && q.peek()[0] <= time) {
                long[] cur = q.poll();
                pq.offer(new int[]{(int) cur[1], (int) cur[2]});
            }

            // Wait for the earliest available server
            if (pq.isEmpty()) {
                time = q.peek()[0];

                while (!q.isEmpty() && q.peek()[0] <= time) {
                    long[] cur = q.poll();
                    pq.offer(new int[]{(int) cur[1], (int) cur[2]});
                }
            }

            // Assign task
            int[] serverInfo = pq.poll();

            res[i] = serverInfo[1];

            q.offer(new long[]{
                time + tasks[i],
                serverInfo[0],
                serverInfo[1]
            });
        }

        return res;
    }
}