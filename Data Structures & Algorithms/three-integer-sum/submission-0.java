class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            twoSum(nums, -nums[i], i + 1, triplets);
            while(i < nums.length - 1 && nums[i] == nums[i+1]){ //to avoid duplicate triplets
                i++;
            }
        }
        return triplets;
    }

    private void twoSum(int[] numbers,  int target, int l,
                        List<List<Integer>> result) {
        int r = numbers.length - 1;
        while (l < r) {
            int currentSum = numbers[l] + numbers[r];
            if (currentSum == target) {
                result.add(List.of(-target, numbers[l], numbers[r]));
                do { //loop is to ensure to duplicate triplets
                    l++;
                }while (l < numbers.length && numbers[l-1] == numbers[l]);
            }else if (currentSum < target) {
                l++;
            }else {
                r--;
            }
        }
    }
}
