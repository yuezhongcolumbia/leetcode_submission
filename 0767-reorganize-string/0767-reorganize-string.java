class Solution {
    public String reorganizeString(String s) {
        // greedy
        // 1. what if two char has same freq? so heap might now work, treemap?
        //     treeMap  Freq: List<Character>
        // 2.question: does this miss potential answer?
        //     dont think so , But i cannot prove it
        // //instantiate treeMap
        // starting from most frequent
        // start traversing, check for the first that is not the duplicate of the last placed string
        // place the string
        // update the map, move the char a tier lower(if freq is >0), remove the key if List is empty

        // edge case:
        // when to stop?
        //     success
        //     fail: single element in the list and is a duplicate
        // map empty

        int[] count = new int[26];
        for(char c: s.toCharArray()){
            count[c - 'a']++;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        for(int i = 0; i < 26; i++){
            if(count[i] == 0) continue;
            maxHeap.offer(new int[]{count[i], i});
        }
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            int[] popFirst = maxHeap.poll();
            char popFirstChar =  (char)(popFirst[1]+'a') ;
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == popFirstChar ){
                if (maxHeap.isEmpty()) return "";
                int[] popSecond = maxHeap.poll();
                char popSecondChar = (char)(popSecond[1]+'a');
                int popSecondFreq = popSecond[0];
                sb.append(popSecondChar);
                if (popSecondFreq - 1 > 0){
                    maxHeap.offer(new int[]{popSecondFreq - 1, popSecond[1]});
                }
                maxHeap.offer(popFirst);
            } else {
                sb.append(popFirstChar);
                if (popFirst[0] - 1 > 0){
                    maxHeap.offer(new int[]{popFirst[0] - 1, popFirst[1]});
                }
            }
        }
        return sb.toString();

        

    }
}