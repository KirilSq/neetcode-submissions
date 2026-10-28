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
        int[] sums = new int[maxSum+1];
        sums[nums[0]] = nums[0]!=0 ? 1 : 2;
        for(int numId = 1; numId < numCount; numId++){
            int num = nums[numId];
            int[] newSums = new int[maxSum+1];
            for(int i = 0; i <= maxSum; i++){
                newSums[i] = 
                + sums[Math.abs(i-num)]
                + (i+num <= maxSum ? sums[i+num] : 0);
            }
            sums = newSums;
        }
        return sums[target];
    }
}
