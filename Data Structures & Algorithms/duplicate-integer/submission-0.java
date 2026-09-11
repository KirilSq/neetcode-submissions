class Solution {
    public boolean hasDuplicate(int[] nums) {
        return hashSetSolution(nums);
    }

    // Time: O(n), Space: O(n)
    private boolean hashSetSolution(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums){
            if (hs.contains(num)) {
                return true;
            }
            hs.add(num);
        }
        return false;
    }

    // Time: O(n*lgn), Space: O(1)
    // Space: O(n) if a copy is made to preserve the og array order
    private boolean sortSolution(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

}