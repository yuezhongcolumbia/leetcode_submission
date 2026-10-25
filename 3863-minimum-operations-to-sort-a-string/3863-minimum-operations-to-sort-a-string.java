class Solution {
    public int minOperations(String s) {
        // //problem: is to know whether we have to sort the entire string once

        // // problem to use stack is that it forgot the last char of the sorted subarray

        // // c a r d 
        // // a c r d 


        // // c a b

        // e d c

        // d e c

        // // at each point we need to whether the char is out of place
        // // after the operation, we need to know the last char of the sorted subarry
        // when a char is out of place, we cannot place it at 0 in one go(meaning sort the entire string)
        // so not only the latest char, we have to remember the entire past memory?

        // // this only builds on the fact that greedy choice is the most opimizaed choice.

        // follwoing the hint, we need to focus get one end point in place and +1 operations
        // int end1 = no of operations to get first endpoint in place
        // int end2 = no of operations to get last endpoint in place
        // res= Math.min(end1, end2) + 1;

        // e d c
        // e c d 
        // c e d  end 1 = 2

        // e d c  end 2  =2 


        // e a d a  end1 = 

        // so there are following situations:
        // 1. the worst:
        //     both end point at in the reverse, end 1 at index 0 and end2 at index n-1, res = 3
        //     1a. edge case, n == 2, res = -1; done 
        // 2. either one end point in the right place: 1  done
        // 3. both end points in the middle: 2
        // 4. both in place: 
        //     sorted :0  done
        //     not sorted: 1  done

        // d e a a -> 
        

        boolean sorted = true;
        int n = s.length();
        char min = 'z';
        char max = 'a';
        for(int i = 0; i < n; i++ ){
            if (i > 0 && s.charAt(i) < s.charAt(i - 1)){
                sorted = false;
            }  
            char c = s.charAt(i);
            if (c < min){
                min = c;
            }
            if (c > max){
                max = c;
            }
        }
        if (sorted) return 0;
        if (n == 2) return -1;

        //either one end point in the right place
        if (s.charAt(0) == min || s.charAt(n - 1) == max){
            return 1;
        }
        // 2 operation, if endpoint appear in the mid, they can move to correct place in one go
        for(int i = 1; i < n - 1; i++){
            char c = s.charAt(i);
            if (c == min || c == max) return 2;
        }
        return 3;
        


        
    }
}