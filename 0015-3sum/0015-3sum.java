class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    //    [-1,0,1,2,-1,-4]
    //    -4 -1 -1 0 1 2
    //     1. sort
    //     2. duplicate?
    //         found, save in res
    //         while loop move left side

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            while(i > 0 && i < nums.length - 2 && nums[i - 1] == nums[i]){
                i++;
            }
            int sum = -nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r){
                int curSum = nums[l] + nums[r];
                if (curSum == sum){
                    List<Integer> trip = new ArrayList<>();
                    trip.add(nums[i]);
                    trip.add(nums[l]);
                    trip.add(nums[r]);
                    res.add(trip);
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l - 1] ){
                        l++;
                    }
                } else if (curSum > sum){
                    r--;
                } else {
                    l++;
                }
                   
            }
                
               
            }

        
        return res;

    }
}