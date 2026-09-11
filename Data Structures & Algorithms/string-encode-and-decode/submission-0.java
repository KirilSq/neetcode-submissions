class Solution {

    private static final char DELIMETER = '#';

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for(String str : strs) {
            result.append(str.length());
            result.append(DELIMETER);
            result.append(str);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new LinkedList<>();
        int i = 0;
        while(i < str.length()){
            int delimeterPos = str.indexOf(DELIMETER, i);
            int strLen = Integer.parseInt(str, i, delimeterPos, 10);
            if(strLen == 0) {
                result.add("");
            } else {
                result.add(str.substring(delimeterPos + 1, delimeterPos + 1 + strLen));
            }
            i = delimeterPos + 1 + strLen;
        }
        return result;
    }
}
