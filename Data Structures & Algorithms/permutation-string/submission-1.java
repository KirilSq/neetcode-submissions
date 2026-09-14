class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Letters[s1.charAt(i) - 'a']++;
        }
        int[] s2LettersUsed = new int[26];
        int l = 0;
        for(int r=0; r < s2.length(); r++){
            char curr = s2.charAt(r);
            if(s1Letters[curr - 'a'] == 0){
                // if the letter isn't contained in the first string.
                // we free up all used letters and move the left pointer
                for (int i = l; i < r ; i++) {
                    s2LettersUsed[s2.charAt(i) - 'a']--;
                }
                l = r + 1;
                continue;
            }
            s2LettersUsed[curr - 'a']++;
            while(s1Letters[curr - 'a'] - s2LettersUsed[curr - 'a']  < 0){
                //frees up used letters, till one becomes available and it will
                s2LettersUsed[s2.charAt(l) - 'a']--;
                l++;
            }
            if(r - l + 1 == s1.length()) {
                return true;
            }
        }
        return false;
    }
}
