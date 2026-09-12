class Solution {
    public int trap(int[] height) {
        int[] prefix = new int[height.length];
        prefix[0] = height[0];
        for(int i = 1; i < height.length; i++){
            prefix[i] = Math.max(prefix[i-1], height[i]);
        }
        int[] postfix = new int[height.length];
        postfix[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i--) {
            postfix[i] = Math.max(postfix[i+1], height[i]);
        }

        int trappedWater = 0;
//water can't be trapped at both ends
        for(int i = 1; i < height.length - 1; i++){ 
            trappedWater += Math.max(0, 
            Math.min(prefix[i-1], postfix[i+1]) - height[i]);
        }
        return trappedWater;
    }
}
