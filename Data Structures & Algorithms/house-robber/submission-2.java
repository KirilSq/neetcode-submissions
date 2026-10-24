class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }else if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        int last = nums[0] + nums[2];
        int second = nums[1];
        int third = nums[0];
        for(int i = 3; i < n; i++){
            int bucket = last;
            last = Math.max(second, third) + nums[i];
            third = second;
            second = bucket;
        }
        return Math.max(last, second);
    }
}
