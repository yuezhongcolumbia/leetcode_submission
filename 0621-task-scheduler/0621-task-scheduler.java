class Solution {
    public int leastInterval(char[] tasks, int n) {
        // to place a char, need to check:
        //     1. check if there is n interval between the previous one
        // to guarentee minimum intervals:
        //     1. we still prioritize most frequent task
        // consider placing empty interval:
        // we need to which task is available, and among which is most frequent.

        // use maxHeap for most frequent
        // what about availability?
        //     we can poll until find a viable task? but we need push back in polled tasks
        
        // Queue
        
        // [4, a, 0][2, b, 0]    [2, b, 0]      []
        // []                    [3,a,3]        [3,a,3][1,b,4]

        // A A A A B B n =2
        // B A x B A x x A x x A
        // A B x A B x A x x A

        int[] count = new int[26];
        for(char c: tasks){
            count[c - 'A']++;
        }
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0],a[0]));
        for(int i = 0; i < 26; i++){
            if (count[i] == 0) continue;
            queue.offer(new int[]{count[i], 0});
        }
        int time = 0;
        while(!queue.isEmpty() || !maxHeap.isEmpty()){
            //queue -> heap
            while(!queue.isEmpty() && queue.peek()[1] <= time){
                maxHeap.offer(queue.poll());
            }
            //pop heap, update freq, availability, result, transfer to queue
            if (!maxHeap.isEmpty()){
                int[] poped = maxHeap.poll();
                int freq = poped[0] - 1;
                int availability = poped[1] + n + 1;
                if (freq > 0){
                   queue.offer(new int[]{freq, availability}); 
                }
            
            }
            time++;
        }
        return time;



    }
}