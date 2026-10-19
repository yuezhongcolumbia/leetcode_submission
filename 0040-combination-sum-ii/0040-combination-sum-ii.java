class Solution {
    int[] candidates;
    int target;
     List<List<Integer>> res;
     List<Integer> path;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    //     unique combo
    //     contains duplicate
    //     all positive
        
    //     1,1,1,2,2,2 target =5
    //     sort,
    //     dedup:
    //       1            1           1       2    2    2  
    //   1 1 2 2 2     1  2 2 2    2 2 2

    //     [1, 1] [1,1] [1,2]
        
        
        
    //     1 , 2, 2, 2, 5

    //     [1, ]   same level dedup
    // need, idx, curSum 
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        res = new ArrayList<>();
        path = new ArrayList<>();
        backtrack(0, 0);
        return res;

    }
    public void backtrack(int curSum, int idx){
        if (curSum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = idx; i < candidates.length; i++){
            if (i > idx && candidates[i] == candidates[i - 1])continue;
            if (curSum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtrack(curSum + candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }
}