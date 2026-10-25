class Solution {
    public int maxProduct(int[] nums) {
        int curMin = nums[0];
        int curMax = nums[0];
        int max = nums[0];
        for(int i=1; i < nums.length; i++){
            curMin*=nums[i];
            curMax*=nums[i];
            int temp = Math.max(curMin, Math.max(curMax, nums[i]));
            curMin = Math.min(curMin, Math.min(curMax, nums[i]));
            curMax = temp;
            max = Math.max(max, curMax);
        }
        return max;
    }

}
