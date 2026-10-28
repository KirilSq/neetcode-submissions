class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int maxSum = 0;
        for(int num : nums){
            maxSum+=num;
        }
        target = Math.abs(target);
        if(target > maxSum){
            return 0;
        }
        int numCount = nums.length;
        int[][] sums = new int[numCount][maxSum+1];
        sums[0][nums[0]] = nums[0]!=0 ? 1 : 2;
        for(int numId = 1; numId < numCount; numId++){
            int num = nums[numId];
            for(int i = 0; i <= maxSum; i++){
                sums[numId][i] = 
                + sums[numId-1][Math.abs(i-num)]
                + (i+num <= maxSum ? sums[numId-1][i+num] : 0);
            }
        }
        return sums[numCount-1][target];
    }
}
