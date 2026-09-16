class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] posSpeedPair = new int[position.length][2];
        for(int i=0; i<position.length; i++){
            posSpeedPair[i][0] = position[i];
            posSpeedPair[i][1] = speed[i];
        }
        Arrays.sort(posSpeedPair, (a, b) -> Integer.compare(b[0], a[0]));
        int fleetCount = 1;
        for(int r = 1; r < position.length; r++){
             double hoursTillTargetPrev = (double) (target - posSpeedPair[r - 1][0]) / posSpeedPair[r-1][1];
            double hoursTillTargetCurr = (double) (target - posSpeedPair[r][0]) / posSpeedPair[r][1];
            if(hoursTillTargetPrev < hoursTillTargetCurr){
                fleetCount++;
            }else {
                posSpeedPair[r][1] = posSpeedPair[r-1][1];
                posSpeedPair[r][0] = posSpeedPair[r-1][0];
            }
        }
        return fleetCount;

    }
}
