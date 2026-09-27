class Solution {
    public List<List<Integer>> permute(int[] nums) {
      //Idea: Use LinkedList to store nums. Use the first el, recursion, backtrack and add the used el to the back of the LinkedList, then try with the new first el and so on.
      LinkedList<Integer> numsCopy = new LinkedList<>();
      for(int num : nums){
        numsCopy.addLast(num);
      }
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> cur = new ArrayList<>();
      dfs(res, numsCopy, cur);
      return res;
    }
    private void dfs(List<List<Integer>> res, LinkedList<Integer> nums, List<Integer> cur){
      if(nums.isEmpty()){
        res.add(new ArrayList<>(cur));
      }else {
        int size = nums.size();
        for(int i=0; i < size; i++){
          cur.add(nums.pollFirst());
          dfs(res, nums, cur);
          nums.add(cur.removeLast());
        }
      }
    }
}
