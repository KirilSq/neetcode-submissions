class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(res, cur, candidates, target, 0);
        return res;
    }

    private void dfs(
        List<List<Integer>> res, List<Integer> cur, int[] candidates, int target, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        } else if (i < candidates.length && target > 0) {
            int candidate = candidates[i];
            int count = 0;
            while (i < candidates.length && candidates[i] == candidate) {
                i++;
                count++;
            }
            int j;
            for (j = 0; j <= count && target >= 0; j++) {
                dfs(res, cur, candidates, target, i);
                cur.add(candidate);
                target -= candidate;
            }

            while (j > 0) {
                cur.removeLast();
                j--;
            }
        }
    }
}
