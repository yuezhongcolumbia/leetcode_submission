class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // 0(1),  3(3),  5(1), 8(4), 10(2)
        // 0(12), 3(4), 5(7), 8(1), 10(1)
        int n = position.length;
        int[][] posSpeed = new int[n][2];
        for(int i = 0; i < n; i++){
            posSpeed[i] = new int[]{position[i], speed[i]};
        }
        Arrays.sort(posSpeed, (a,b) -> Integer.compare(a[0], b[0]));
        Stack<Double>stack = new Stack<>();
        for(int i = 0; i < n; i++){
            int curSpeed = posSpeed[i][1];
            int curPos = posSpeed[i][0];
            double curTime = (double)(target - curPos) / curSpeed;
            while(!stack.isEmpty() && curTime >= stack.peek() ){
                stack.pop();
            }
            stack.push(curTime);
        }
        return stack.size();
        
    }
}