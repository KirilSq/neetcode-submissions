class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int one, two, three;
        int i = 0;
        while(i < triplets.length - 1 && !isValid(triplets[i], target)){
            i++;
        }
        one = triplets[i][0];
        two = triplets[i][1];
        three = triplets[i][2];
        i++;
        while(i < triplets.length && !(one == target[0] 
        && two == target[1] && three == target[2])){
            if(isValid(triplets[i], target)){
                one = Math.max(one, triplets[i][0]);
                two = Math.max(two, triplets[i][1]);
                three = Math.max(three, triplets[i][2]);
            }
            i++;
        }
        return one == target[0] && two == target[1] && three == target[2];
    }

    private boolean isValid(int[] triplet, int[] target){
        return triplet[0] <= target[0]
        && triplet[1] <= target[1]
        && triplet[2] <= target[2];
    }
}
