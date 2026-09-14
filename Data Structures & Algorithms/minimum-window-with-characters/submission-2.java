class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        int[] tFrequencies = new int['z' - 'A' + 1];
        for(int i=0; i < t.length(); i++){
            tFrequencies[t.charAt(i) - 'A']++;
        }
        int[] usedFrequencies = new int['z' - 'A' + 1];
        int l = 0;
        boolean[] fullfilledFrequencies = new boolean['z' - 'A' + 1];
        int fullfilledLetters = 0;
        int[] bestCurrentLR = {-1, Integer.MAX_VALUE - 1};
        for(int r = 0; r < s.length(); r++){
            usedFrequencies[s.charAt(r) - 'A']++;
            while(l <= r && usedFrequencies[s.charAt(l) - 'A'] >
                    tFrequencies[s.charAt(l) - 'A']) {
                usedFrequencies[s.charAt(l) - 'A']--;
                l++;
            }
            if(usedFrequencies[s.charAt(r) - 'A'] ==
                    tFrequencies[s.charAt(r) - 'A'] && !fullfilledFrequencies[s.charAt(r) - 'A']){
                fullfilledLetters+=tFrequencies[s.charAt(r) - 'A'];
                fullfilledFrequencies[s.charAt(r) - 'A'] = true;
            }
            if(fullfilledLetters == t.length() &&
                    r - l <= bestCurrentLR[1] - bestCurrentLR[0]){
                bestCurrentLR[0] = l;
                bestCurrentLR[1] = r;
            }
        }
        return bestCurrentLR[0] == -1 ?
                "" :
                s.substring(bestCurrentLR[0], bestCurrentLR[1]+1);
    }
}
