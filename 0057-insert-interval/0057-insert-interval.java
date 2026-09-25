class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 1. can merge with current
        //     no intersect, add cur interval to result
        //     intersection, do not add anything, update tmp, and keep merging
        // 2. can directly insert
        //     can insert in front：  
        int n = intervals.length;
        int[] tmp = newInterval;
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if (tmp == null){
                res.add(intervals[i]);
            }
            else if (intersect(tmp, intervals[i])){
                tmp = merge(tmp, intervals[i]);
            } else if (canInsertInFront(tmp, intervals[i])){
                res.add(tmp);
                res.add(intervals[i]);
                tmp = null;
            } else {
                res.add(intervals[i]);
            }
        }
        if (tmp != null) res.add(tmp);
        int[][] resArr = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            resArr[i] = res.get(i);
        }
        return resArr;


           
    }
    public boolean intersect(int[] a, int[] b){
        return !(a[1] < b[0]|| a[0] > b[1]);
    }
    public int[] merge(int[] a, int[] b){
        return new int[]{Math.min(a[0], b[0]),  Math.max(a[1], b[1])  };
    }
    public boolean canInsertInFront(int[] a, int[] b){
        return a[1] < b[0];
    }
}