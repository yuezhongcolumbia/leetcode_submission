class Solution {
    public long countCommas(long n) {
        // 1002
        // length?
        // can we just divide by 1000 until it is 0?
        
        // 998,089 ->90

        // 120,235,321

        // 1,000 - 999,999 1 comma (998,999) * 1
        // 1,000,000 - 120, 235,321 2 comma (119,235,321) * 2
        
        // 1,000 999,999
        // 2,000 1000,1001

        long res = 0L;
        for(long thresh = 1000; thresh <= n; thresh *= 1000){
            res += n - thresh + 1;
        }
        return res;
        
    }
}