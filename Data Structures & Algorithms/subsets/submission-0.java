class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>(1 << nums.length);
        subsets.add(List.of());
        for (int num : nums) {
            int subsetCnt = subsets.size();
            for (int i = 0; i < subsetCnt; i++) {
              List<Integer> subsetI = subsets.get(i);
              List<Integer> withNumIncluded = new ArrayList<>(subsetI.size() + 1);
              withNumIncluded.addAll(subsetI);
              withNumIncluded.addLast(num);
              subsets.addLast(withNumIncluded);
            }
        }
        return subsets;
    }
}
