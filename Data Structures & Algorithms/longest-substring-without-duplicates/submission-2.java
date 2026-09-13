class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> usedCharacters = new HashMap<>(s.length());
        int maxLen = 0;
        int currLen = 0;
        for (int i = 0; i < s.length(); i++) {
            Character currCh = s.charAt(i);
            if(!usedCharacters.containsKey(currCh)){
                currLen++;
            }else {
                int currChPrevIndex = usedCharacters.get(currCh);
                int lowestUsedIndex = i - currLen;
                for(int j = lowestUsedIndex; j <= currChPrevIndex ; j++) {
                    usedCharacters.remove(s.charAt(j));
                }
                currLen = i - currChPrevIndex;
            }
            usedCharacters.put(currCh, i);
            maxLen = Math.max(currLen, maxLen);
        }
        return maxLen;
    }
}
