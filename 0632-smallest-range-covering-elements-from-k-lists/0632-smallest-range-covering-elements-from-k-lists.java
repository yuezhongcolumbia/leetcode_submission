class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // the left boundary

        //     4                   26
        // 0                 20
        //       5                        30

        //       when I pick a number, I want to know if there is at least one number from other list, that is greater or equanl than this 

        //       4,10,15,24
        //       0,9,12,20
        //       5,18,22
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int bestStart = Integer.MAX_VALUE;
        int bestEnd = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i++){
            int value =nums.get(i).get(0); 
            minHeap.offer(new int[]{value, i, 0});
            bestStart = Math.min(bestStart, value);
            bestEnd = Math.max(bestEnd, value); 
        }
        int curMin  = bestStart;
        int curMax = bestEnd;
        while(true){
            //get the candidate
            int[] cur = minHeap.poll();
             curMin = cur[0];
            int curListIndex = cur[1];
            int curElementIndex = cur[2];
            //compare
            if (curMax - curMin < bestEnd - bestStart){
                bestStart = curMin;
                bestEnd = curMax;
            }
            if (curElementIndex + 1 == nums.get(curListIndex).size()) break;
            //offer another cndidate to the heap
            int nextCandidate = nums.get(curListIndex).get(curElementIndex + 1);
            curMax = Math.max(curMax, nextCandidate);
            minHeap.offer(new int[]{nextCandidate, curListIndex, curElementIndex + 1});
        }
        return new int[]{bestStart, bestEnd};
    }
}