class RandomizedSet {
    
    
    //  0  1  2
    //  5, 9, 11

    //  O（1） getRandom(), ok
    //  O (1) insert, append ok, check present ( map,containsKey())
    //  O(1) removal, i need location of val:
    //     map<val, index>
    //     find val
    //     change it to last element, update map
    //     delete last element, update map
    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int valIdx = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(valIdx, last);
        map.put(last, valIdx);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIdx = random.nextInt(list.size());
        return list.get(randomIdx );
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */