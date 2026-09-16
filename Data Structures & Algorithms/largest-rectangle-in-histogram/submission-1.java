class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> mono = new ArrayDeque<>();
        mono.push(new int[]{heights[0], 0});
        int maxArea = heights[0];
        for(int i = 1; i < heights.length; i++){
            int height = heights[i];
            int indexToPush = i;
            while(!mono.isEmpty() && height < mono.peek()[0]) {
                int[] bar = mono.pop();
                maxArea = Math.max(maxArea, bar[0] * (i - bar[1]));
                indexToPush = bar[1];
            }
            mono.push(new int[]{height, indexToPush});
        }
        while(!mono.isEmpty()){
            int[] bar = mono.pop();
            maxArea = Math.max(maxArea, bar[0] * (heights.length - bar[1]));
        }
        return maxArea;
    }
}
