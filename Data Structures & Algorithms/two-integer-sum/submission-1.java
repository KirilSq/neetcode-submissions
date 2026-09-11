class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valueIdPairs = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int left = target - nums[i];
                if(valueIdPairs.containsKey(left)){
                    return new int[]{valueIdPairs.get(left), i};
                }
                valueIdPairs.put(nums[i], i);
            }
            return new int[]{0, 0};
    }
}
