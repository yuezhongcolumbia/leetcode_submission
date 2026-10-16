class FirstUnique {
    Deque<Integer> dq;
    Map<Integer, Integer> count;
    
    public FirstUnique(int[] nums) {
        dq = new ArrayDeque<>();
        count = new HashMap<>();
        for(int num: nums){
            dq.offerLast(num);
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
    }
    
    public int showFirstUnique() {
        while (!dq.isEmpty() &&  count.get(dq.peekFirst()) > 1){
            int poped = dq.pollFirst();
           
        }
       if (!dq.isEmpty() ) return dq.peekFirst();
       return -1;
    }
    
    public void add(int value) {
        dq.offerLast(value);
        count.put(value, count.getOrDefault(value, 0) + 1);
        
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */