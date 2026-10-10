class Solution {
    public int maxArea(int[] height) {
      int l = 0;
      int r = height.length - 1;
      int res = Integer.MIN_VALUE;
      while (l < r){
        int area = Math.min(height[l], height[r]) * (r - l);
        res = Math.max(res, area);
        if (height[l] <= height[r]){
            l++;
        } else {
            r--;
        }
      }   
      return res;
    }
}