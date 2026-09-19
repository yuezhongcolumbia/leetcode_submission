class Solution {
    public int hIndex(int[] citations) {
        
        // 0 1 2 3 4
        // 0 1 3 5 6
        Arrays.sort(citations);
        int h = citations.length;
        for(int i = 0; i < citations.length; i++){
            if (citations[i] >= h) return h;
            h--;
        }
        return h;
    }
}