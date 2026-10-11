class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int equalPairs = 0;
        Map<String, Integer> count = new HashMap<>();
        int flipPairs = 0;
        for(int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i - 1]){
                equalPairs++;
                continue;
            }
            int a = nums[i - 1];
            int b = nums[i];
            int x = Math.min(a,b);
            int y = Math.max(a,b);
            String key = x + "," + y;
            count.put(key, count.getOrDefault(key, 0) + 1);
            flipPairs = Math.max(flipPairs, count.get(key));
        }
        return flipPairs + equalPairs;
    }
}