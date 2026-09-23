class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // use start or end for finding insertion point? start
        
        // [1,100]   [101,102]    [99,102]


        // insert on the left
        //     merge with prev interval?
        //     merge with cur interval?
           
        //     if I merge into 
        if (intervals.length == 0){
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        List<int[]> res = new ArrayList<>();
        int pos = binarySearch(intervals, newInterval);
        int[] tmp = newInterval;

        if (pos > 0){
            for(int i = 0; i < pos - 1; i++){
                res.add(intervals[i]);
            }
             if (intersect(intervals[pos - 1], newInterval)){
                tmp = merge(intervals[pos - 1], newInterval);
             } else {
                res.add(intervals[pos - 1]);
             }
        }
       
        for(int i = pos; i < intervals.length; i++){
            if (intersect(intervals[i], tmp)){
                tmp = merge(intervals[i], tmp);
            } else {
                res.add(tmp); 
                for(int j = i; j < intervals.length; j++){
                    res.add(intervals[j]);
                }
                
                tmp = null;
                break;
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
        return !(a[1] < b[0] || a[0] > b[1]) ;
    }
    public int[] merge(int[] a, int[] b){
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1],b[1])};
    }
    public int binarySearch(int[][] intervals, int[] newInterval){
        int l = 0;
        int r = intervals.length - 1;
        int res = -1;
        while(l <= r){
            int m = (l + r) >> 1;
            if (intervals[m][0] >= newInterval[0]){
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res != -1 ? res : intervals.length ;
    }
}