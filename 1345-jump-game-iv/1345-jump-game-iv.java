class Solution {
    public int minJumps(int[] arr) {
        //prepare graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i< arr.length; i++){
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        //prepare visit
        Set<Integer> visit = new HashSet<>();
        // prepare queue
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visit.add(0);
       int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int curIdx = q.poll();
                if (curIdx == arr.length - 1) return step;
                if (curIdx - 1 >= 0 && !visit.contains(curIdx - 1)){
                    visit.add(curIdx -1);
                    q.offer(curIdx - 1);
                }
                if (curIdx + 1 < arr.length && !visit.contains(curIdx + 1)){
                    visit.add(curIdx + 1);
                    q.offer(curIdx + 1);
                }
                if (graph.containsKey(arr[curIdx])){
                   List<Integer> neighbor = graph.get(arr[curIdx]);
                for(int next: neighbor){
                    if (!visit.contains(next)){
                        visit.add(next);
                        q.offer(next);
                    }
                }
                graph.remove(arr[curIdx]); 
                }
                
            }
            step++;
        }
        return step;
    }
}