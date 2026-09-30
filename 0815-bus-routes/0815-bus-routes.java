class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // 1: 0   
        // 2: 0
        // 3: 1
        // 6: 1
        // 7: 0, 1

        // 7:  0
        // 12: 0,4
        // 4: 1
        // 5: 1
        // 15: 1, 3
        // 6: 2
        // 19: 3
        // 9: 4
        // 13: 4
          if (source == target) return 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
         Queue<Integer> q = new LinkedList<>();
         Set<Integer> visit = new HashSet<>();
        for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                int stop = routes[i][j];
                int bus = i;
                graph.computeIfAbsent(stop, k -> new ArrayList<>()).add(bus);
                if (stop == source){
                    q.offer(bus);
                    visit.add(bus);
                }
            }
        }
       
        int step = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int bus = q.poll();
                for(int stopIdx = 0; stopIdx < routes[bus].length; stopIdx++){
                    int stop = routes[bus][stopIdx];
                    if (stop == target) return step;
                    List<Integer> nextBusList = graph.get(stop);
                    for(int nextBus: nextBusList ){
                        if (visit.contains(nextBus))continue;
                        visit.add(nextBus);
                        q.offer(nextBus);
                    }
                }
            }
            step++;
        }
        return -1;
        


    }
}