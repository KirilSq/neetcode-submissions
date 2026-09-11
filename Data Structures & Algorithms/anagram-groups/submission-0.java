class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        LinkedHashMap<String, List<String>> groupsByAnagram = new LinkedHashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String currentAnagram = strToSorted(strs[i]);
            if(!groupsByAnagram.containsKey(currentAnagram)){
                List<String> anagramList = new ArrayList<>();
                anagramList.add(strs[i]);
                groupsByAnagram.put(currentAnagram, anagramList);
            }else {
                groupsByAnagram.get(currentAnagram).add(strs[i]);
            }
        }
        return groupsByAnagram.values().stream().toList();
    }

     private String strToSorted(String str) {
        int[] charactersCount = new int[26];
        for (int i = 0; i < str.length(); i++) {
            charactersCount[str.charAt(i) - 97] ++;
        }
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < 26; i++) {
            for(int j = 0; j < charactersCount[i]; j++){
                result.append(97 + i);
            }
        }
        return result.toString();
    }
}
