class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // 1. how to model the state, consecutive letter:
        // index
        // streak 
        // totalweight
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
        int[][] cost = new int[n][k + 1];
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] edge: edges){
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph.computeIfAbsent(from, key -> new ArrayList<>()).add(new int[]{to, weight});
        }
        for(int[] arr: cost){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        cost[0][1] = 0;
        pq.offer(new int[]{0,0,1});



        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int totalWeight = cur[0];
            int node = cur[1];
            int streak = cur [2];
            if (node == n - 1){
                return totalWeight;
            }
            if (cost[node][streak] < totalWeight){
                continue;
            }
            for (int[] next: graph.getOrDefault(node, new ArrayList<>())){
                int nextNode = next[0];
                int nextWeight = next[1];
                char currentChar = labels.charAt(node);
                char nextChar = labels.charAt(nextNode);
                int nextStreak = streak;
                if (currentChar == nextChar){
                    nextStreak++;
                } else {
                    nextStreak = 1;
                }
                if (nextStreak <= k && totalWeight + nextWeight < cost[nextNode][nextStreak]){
                    pq.offer(new int[]{totalWeight + nextWeight, nextNode, nextStreak});
                   cost[nextNode][nextStreak] = totalWeight + nextWeight;
                }
            }
        }
        return -1;
    }
}