class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int lowestK = Integer.MAX_VALUE;
        while(l <= r) {
            int k = l + (r - l) / 2;
            int hoursPassed = 0;
            for(int i = 0; i < piles.length && hoursPassed <= h; i++){
                hoursPassed+= (piles[i] + k - 1) / k;
            }
            if(hoursPassed <= h) {
                lowestK = k;
                r = k - 1;
            }else {
                l = k + 1;
            }
        }
        return lowestK;
    }
}
