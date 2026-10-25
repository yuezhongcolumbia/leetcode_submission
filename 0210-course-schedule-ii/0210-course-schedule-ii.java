class Solution {
    List<Integer> res;
    List<List<Integer>> graph;
    List<List<Integer>> graphPre;
    int[] state;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    //     directed graph

 
    //        0      5         0: 1 , 2    1:3  2 : 3
    //     1    2              3:1 , 2   1:0   2:0 0
    //  3         3

    //   dfs:
    //     1. build two graphs, one to find the root, another to traverse.
    //     2. visit for cycle detection
        // 3.its kind of hard to use dfs to attempt to explore all courses
        
         //
         graph = new ArrayList<>();
      
         res = new ArrayList<>();
         state = new int[numCourses];
         for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
          
         }
         for(int[] preRequisite: prerequisites){
            int node = preRequisite[0];
            int pre = preRequisite[1];
            graph.get(pre).add(node);
           
         }
          for(int i = 0; i < numCourses; i++){
            if (state[i] == 0){
                if (!dfs(i)){
                    return new int[]{};
                }
            }
          }
          Collections.reverse(res);

        return res.stream().mapToInt(Integer::intValue).toArray();

    }
    
    //        0      5         0: 1 , 2    1:3  2 : 3
    //     1    2              3:1 , 2   1:0   2:0 0
    //  3      3  4

//  2       0
//      1
  

    public boolean dfs(int node){
        
        if(state[node] == 1){
            return false;
        }
        state[node] = 1;
        List<Integer> nextCourse = graph.get(node);
        for(int next: nextCourse){
            if (state[next] == 2) continue;
            if(!dfs(next)){
                return false;
            }
        }
        res.add(node);
        state[node] =2;
        return true;
    }
}