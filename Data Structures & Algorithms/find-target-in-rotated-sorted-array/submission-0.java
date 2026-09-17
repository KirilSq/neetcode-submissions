class Solution {
    public int search(int[] nums, int target) {
        int l = 1;
        int r = nums.length;
        int rotations = nums.length;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[0] < nums[mid%nums.length]){
                l = mid + 1;
            }else {
                rotations = Math.min(rotations, mid);
                r = mid - 1;
            }
        }

        if(nums[0] <= target){
            l = 0;
            r = rotations - 1;
        }else {
            l = rotations;
            r = nums.length -1;
        }

        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < target){
                l = mid + 1;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else {
                return mid;
            }
        }

        return -1;
    }
}
