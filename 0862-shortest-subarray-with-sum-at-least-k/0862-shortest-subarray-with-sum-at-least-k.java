class Solution {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] prefix = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++){
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        int res = Integer.MAX_VALUE;
        for(int r = 0; r <= nums.length; r++){
            while(!dq.isEmpty() && prefix[r] - prefix[dq.peekFirst()] >= k ){
                res = Math.min(res, r - dq.pollFirst());
            }
            while (!dq.isEmpty() && prefix[r] <= prefix[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(r);
        }
        return res != Integer.MAX_VALUE ? res : -1;
    }
}
// 1 2 3 4 
// 0 1 3 6 10