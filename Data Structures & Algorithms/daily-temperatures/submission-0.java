class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> monoDecr = new ArrayDeque<>(temperatures.length); 
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!monoDecr.isEmpty()
                    && temperatures[monoDecr.peek()] < temperatures[i]){
                int popped = monoDecr.pop();
                result[popped] = i - popped;
            }
            monoDecr.push(i);
        }
        while(!monoDecr.isEmpty()){
            result[monoDecr.pop()] = 0;
        }
        return result;
    }
}
