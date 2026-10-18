class Solution {
    public boolean uniformArray(int[] nums1) {
        // 2 operations:
        //     1. do nothing
        //     2. find someone smaller to deduct
        
        // two issues:
        // 1. which parity to flip?
        //     we can try both, all odds or all even.
        // 2. where to find if I need deduction?
        //     even - odd = odd
        //     odd - odd = even
        //     both case needs odd

        //     make life easier, we can sort, but there are duplicates
        //     1, 5,8,9
        //     we need an odd number, which appears as early as possible 

        // 补充： if there is odd existing, there is no way that guy gonna flip to even;
        // so we can only hope to flip all evens to all odds.
        // 1 4 6

        Arrays.sort(nums1);
        int deduct = Integer.MAX_VALUE;
        for(int i = 0; i < nums1.length; i++){
            if (nums1[i] % 2 != 0){
                deduct = nums1[i];
                break;
            }
        }
        // all even
        if (deduct == Integer.MAX_VALUE) return true;
        //all even
        // boolean allEven = true;
        // for(int num: nums1){
        //     if (num % 2 == 0) continue;
        //     if (num > deduct){
        //         continue;
        //     } else {
        //         allEven = false;
        //         break;
        //     }
        // }
        // to all odds
         for(int num: nums1){
            if (num % 2 == 1) continue;
            if (num < deduct){
                return false;
            }
               
        }
        return true;


    }
}