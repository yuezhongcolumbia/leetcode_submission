class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        // count number of server got request in the interval

        // 3 : 1
        // 5 : 1
        // 6 : 2

        // 3: 2,3
        // 5: 2,3
        // 6: 1,3
        int[][] sortedQuery = new int[queries.length][2];
        for(int i = 0; i < queries.length; i++){
            sortedQuery[i][0] = queries[i];
            sortedQuery[i][1] = i;
        }

        Arrays.sort(logs, (a,b)->Integer.compare(a[1],b[1]));
        Arrays.sort(sortedQuery, (a,b) -> Integer.compare(a[0],b[0]));

        Map<Integer, Integer> map = new HashMap<>();
    
        int left = 0;
        int right = 0;
        int[] res = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++){
           while(right < logs.length && logs[right][1] <=sortedQuery[i][0]){
            int server = logs[right][0];
            map.put(server, map.getOrDefault(server, 0) + 1);
            right++;
           }
           while (left < right && logs[left][1] < sortedQuery[i][0] - x){
            int server = logs[left][0];
            map.put(server, map.get(server) - 1);
            if (map.get(server) == 0){
                map.remove(server);
            }
            left++;
           }
           res[sortedQuery[i][1]] = n - map.size();
        }
        return res;
        
        // [1,2][1,5][2,6]  [10,11]
    }
}