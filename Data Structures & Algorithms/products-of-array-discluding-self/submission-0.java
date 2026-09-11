class Solution {
    public int[] productExceptSelf(int[] nums) {
         if(nums.length == 0){
            return new int[0];
        }
        int[] leftProduct = new int[nums.length];
        leftProduct[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i-1] * nums[i];
        }

        int[] rightProduct = new int[nums.length];
        rightProduct[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i+1] * nums[i];
        }

        int[] result = new int[nums.length];
        result[0] = nums.length == 1 ? 1 : rightProduct[1];
        result[nums.length - 1] = nums.length == 1 ? 1 : leftProduct[nums.length-2];
        for (int i = 1; i < nums.length - 1; i++) {
            result[i] = leftProduct[i-1] * rightProduct[i + 1];
        }
        return result;
    }
}  
