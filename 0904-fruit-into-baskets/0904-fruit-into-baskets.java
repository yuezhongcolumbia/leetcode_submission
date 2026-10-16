class Solution {
    public int totalFruit(int[] fruits) {
        int res = 0;
        int l = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int r = 0; r < fruits.length; r++){
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            while(map.size() > 2){
                int fruitL = fruits[l];
                map.put(fruitL, map.get(fruitL) - 1);
                l++;
                if (map.get(fruitL) == 0) {
                    map.remove(fruitL);
                }
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}