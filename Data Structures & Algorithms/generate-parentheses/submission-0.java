class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        dfs(res, cur, n, n);
        return res;
    }
    private void dfs(List<String> res, StringBuilder cur, int openingLeft, int closingLeft){
        if(openingLeft == 0){
            cur.append(")".repeat(closingLeft));
            res.add(cur.toString());
            cur.delete(cur.length() - closingLeft, cur.length());
        }else {
            if(openingLeft < closingLeft){
                cur.append(")");
                dfs(res, cur, openingLeft, closingLeft - 1);
                cur.deleteCharAt(cur.length() - 1);
            }
            cur.append("(");
            dfs(res, cur, openingLeft - 1, closingLeft);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
