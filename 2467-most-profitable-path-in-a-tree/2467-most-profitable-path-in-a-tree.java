class Solution {
    int[] amount;
    int[] bobTime;
    Map<Integer, List<Integer>> graph;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        this.amount = amount;
        bobTime = new int[edges.length + 1];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        graph = new HashMap<>();
        for(int i = 0; i <= edges.length; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        bobPath(bob, -1, 0);
        return dfs(0, 0, -1);
    }
    public boolean bobPath(int node, int parent, int time){
        if (node == 0){
            bobTime[node] = time;
            return true;
        }
        for(int next: graph.get(node)){
            if (next == parent) continue;
            if (bobPath(next, node, time + 1)){
                bobTime[node] = time;
                return true;
            }
        }
        return false;
    }

    public int dfs(int node, int time, int parent){
        int res = 0;
        //current profit
        if (bobTime[node] > time){
            res += amount[node];
        } else if (bobTime[node] == time){
            res += amount[node] / 2;
        }
        int neighborProfit = Integer.MIN_VALUE;
        List<Integer> neighbors = graph.get(node);
        if (neighbors.size() == 1 && node != 0) return res;
        for(int next: neighbors){
            if (next == parent) continue;
            neighborProfit = Math.max(neighborProfit, dfs(next, time + 1, node));
        }
        return res + neighborProfit;

    }
}