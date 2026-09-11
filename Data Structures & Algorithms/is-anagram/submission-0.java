class Solution {
        public boolean isAnagram(String s, String t) {
            if(s.length() != t.length()){
            return false;
        }
        int[] characters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            characters[s.charAt(i) - 97]++;
            characters[t.charAt(i) - 97]--;
        }

        for (int i = 0; i < 26; i++) {
            if(characters[i] != 0) {
                return false;
            }
        }
        return true;
        }
}
