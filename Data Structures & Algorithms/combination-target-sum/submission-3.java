class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtr(res, curr, nums, 0, target);
        return res;
    }

    private void backtr(
        List<List<Integer>> res, List<Integer> curr, int[] nums, int i, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        } else if (target < 0 || i >= nums.length) {
            return;
        } else {
            int targetCopy = target;
            while(targetCopy >= 0){
              backtr(res, curr, nums, i + 1, targetCopy);
              curr.addLast(nums[i]);
              targetCopy-=nums[i];
            }
            while(targetCopy < target) {
             curr.removeLast();
             targetCopy+=nums[i];
            }
        }
    }
}
