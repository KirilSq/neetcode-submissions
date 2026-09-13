class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> frequency = new HashMap<>(s.length());
        int l = 0, maxFrequency = 0;
        int result = 0;
        for(int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
            maxFrequency = Math.max(frequency.get(ch), maxFrequency);
            while( (1 + r - l) - maxFrequency > k) {
                frequency.put(s.charAt(l), frequency.get(s.charAt(l)) - 1);
                l++;
            }
            result = Math.max(result, 1 + r - l);
        }
        return result;
    }
}
