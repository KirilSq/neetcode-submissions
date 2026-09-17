class Solution {
    public int findMin(int[] nums) {
        int l = 1;
        int r = nums.length;
        //binary search on rotation count. Checking the relation between the first and the mid element to determine right or left range should change
        int rotationCandidate = nums.length;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[0] < nums[mid%nums.length]){
                l = mid + 1;
            }else {
                rotationCandidate = Math.min(rotationCandidate, mid);
                r = mid - 1;
            }
        }
        return nums[rotationCandidate % nums.length];
    }
}
