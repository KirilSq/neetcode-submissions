class Trie {
    public Trie[] children;
    public boolean isWord;
    
    public Trie(){
        children = new Trie[26];
        isWord = false;
    }

    public void insert(String s){
        Trie cur = this;
        int len = s.length();
        for(int i=0; i<len; i++){
            int ch = s.charAt(i) - 'a';
            if(cur.children[ch] == null){
                cur.children[ch] = new Trie();
            }
            cur = cur.children[ch];
        }
        cur.isWord = true;
    }

}


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for(String word : wordDict){
            trie.insert(word);
        }
        int len = s.length();
        boolean[] dp = new boolean[len];
        for(int i = 0; i < len; i++){
            if(i > 0 && !dp[i-1]){
                continue;
            }
            Trie cur = trie;
            for(int j=i; j<len; j++){
                cur = cur.children[s.charAt(j) - 'a'];
                if(cur == null){
                    break;
                }
                dp[j] = dp[j] || cur.isWord;
            }
        }
        return dp[len-1];
    }
}
