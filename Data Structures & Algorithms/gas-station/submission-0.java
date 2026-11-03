class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int lastGood = 0;
        int tank = 0;
        int totalGas = 0;
        for(int i=0; i<gas.length; i++){
            if(tank < 0){
                tank=0;
                lastGood = i;
            }
            tank+=gas[i];
            totalGas+=gas[i] - cost[i];
            tank-=cost[i];
        }
        return totalGas >= 0 ? lastGood : -1;
    }
}
