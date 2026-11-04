class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        // not sorted
        // negative number

        // what matter is the first digit and the last digit

        // 5 2 5 2 k = 3
        // 5: 0, 2
        // 2: 1, 3
        // the problem is how to prevent reprocess same subarry



        // you also need to know what's in the middle, to update ans:
        //     use prefix Sum you dont
        // brute force O(N^2)not passable
        Map<Integer, Long> map = new HashMap<>();
        long res = Long.MIN_VALUE;
        long[] prefix = new long[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            //update map
            int key = nums[i];
            map.merge(key, prefix[i], Math::min);
            //update prefix for cur
            prefix[i + 1] = prefix[i] + key;
            //update res
            int upper = key + k;
            int lower = key - k;
            if (map.containsKey(upper)){
                res = Math.max(res, prefix[i + 1] - map.get(upper));
            }
            if (map.containsKey(lower)){
                res = Math.max(res, prefix[i + 1] - map.get(lower));
            }

        }
        return res != Long.MIN_VALUE ? res : 0;


    }
    // 0  1 2 3
    // [0,1,3,6]

    // nums = [5, -100, 5, 2，-1000， 2];
    // k = 3

//     [-1,-2,-3,-4]
//    0,-1,-3,-6,-10
}