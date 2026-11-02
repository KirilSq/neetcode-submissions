class Solution {
    public int jump(int[] nums) {
        int maxJump = 0;
        int jumpCount = 0;
        int currRange = 0;
        while(currRange < nums.length - 1){
            for(int i = 0; i <= currRange; i++){
                maxJump = Math.max(maxJump, i + nums[i]);
            }
            jumpCount++;
            currRange = maxJump;
        }
        return jumpCount;
    }
}
