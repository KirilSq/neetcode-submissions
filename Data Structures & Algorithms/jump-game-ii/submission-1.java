class Solution {
    public int jump(int[] nums) {
        int maxJump = 0;
        int jumpCount = 0;
        int l = 0;
        int r = 0;
        while(r < nums.length - 1){
            for(int i = l; i <= r; i++){
                maxJump = Math.max(maxJump, i + nums[i]);
            }
            jumpCount++;
            l = r + 1;
            r = maxJump;
        }
        return jumpCount;
    }
}
