class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>(nums.length);
        for(int num : nums) {
            numSet.add(num);
        }

        int longestLength = 0;
        for(int num : nums) {
            if(!numSet.contains(num-1)){
                int currLength = 1;
                while(numSet.contains(++num)){
                    currLength++;
                }
                longestLength = Math.max(longestLength, currLength);
            }
        }
        return  longestLength;
    }
}
