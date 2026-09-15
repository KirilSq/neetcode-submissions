class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> maximumCandidates = new LinkedList<>();
        for(int i = 0; i < k; i++){
            addElToCandidates(nums[i], maximumCandidates);
        }
        int[] result = new int[nums.length - k + 1];
        result[0] = maximumCandidates.getFirst();
        for (int l = 1; l <= nums.length - k; l++) {
            if(nums[l-1] == maximumCandidates.getFirst()){
                maximumCandidates.removeFirst();
            }
            addElToCandidates(nums[l+k-1], maximumCandidates);
            result[l] = maximumCandidates.getFirst();
        }
        return result;
    }
    private void addElToCandidates(int el, Deque<Integer> candidates){
        while(!candidates.isEmpty() && candidates.getLast() < el){
            candidates.removeLast();
        }
        candidates.addLast(el);
    }
}
