class Solution {
    public int findDuplicate(int[] nums) {
        // nums can be interpreted as a graph, thus floyd's cycle detection algorithm can be applied
        int slowP = nums[0];
        int fastP = nums[nums[0]];
        while(slowP != fastP){
            slowP = nums[slowP];
            fastP = nums[nums[fastP]];
        }
        
        slowP = 0;
        while(slowP != fastP){
            slowP = nums[slowP];
            fastP = nums[fastP];
        }

        return slowP;
    }
}
