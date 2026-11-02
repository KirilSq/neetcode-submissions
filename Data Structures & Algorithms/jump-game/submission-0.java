class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for(int i=0; i < nums.length - 1; i++){
            int curr = nums[i];
            if(curr == 0 && maxJump <= i){
                return false;
            }
            maxJump = Math.max(maxJump, i + curr);
        }
        return true;
    }
}
