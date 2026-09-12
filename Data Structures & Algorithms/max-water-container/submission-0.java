class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxArea = 0;
        while(l < r) {
            maxArea = Math.max(maxArea,
            Math.min(heights[l], heights[r]) * (r - l) );
            if(heights[l] > heights[r]){
                r--;
            }else {
                l++;
            }
        }
        return maxArea;
    }
}
