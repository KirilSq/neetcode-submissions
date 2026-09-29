class Solution {
    private Character[][] digitToChar = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
        {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'q', 'p', 'r', 's'}, {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList();
        if (digits != null && digits.length() > 0) {
            StringBuilder cur = new StringBuilder();
            dfs(res, cur, digits, 0);
        }
        return res;
    }

    private void dfs(List<String> res, StringBuilder cur, String digits, int i) {
        if (i == digits.length()) {
            res.add(cur.toString());
            return;
        } else {
            int digit = digits.charAt(i) - '0';
            for (char ch : digitToChar[digit]) {
                cur.append(ch);
                dfs(res, cur, digits, i + 1);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}
