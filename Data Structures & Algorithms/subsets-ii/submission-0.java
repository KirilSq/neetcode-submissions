class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); //Sorting isn't fully needed. Just transforming the elements in to a Map-like structure of type (val, count) would do the job
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>(nums.length);
        dfs(res, cur, nums, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> cur, int[] nums, int i) {
        if(i >= nums.length){
            res.add(new ArrayList<>(cur));
        }else {
            int count = 0;
            int num = nums[i];
            while(i < nums.length && nums[i] == num){
                count++;
                i++;
            }
            dfs(res, cur, nums, i);
            for(int j = 1; j <= count; j++){
                cur.add(num);
                dfs(res, cur, nums, i);
            }
            for(int j = 1; j <= count; j++) {
                cur.removeLast();
            }
        }
    }
}
