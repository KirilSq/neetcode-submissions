class WordDictionary {
    private class TrieNode {
        TrieNode[] children;
        boolean endOfWord;
        public TrieNode() {
            children = new TrieNode[26];
            endOfWord = false;
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int chNum = word.charAt(i) - 'a';
            if (cur.children[chNum] == null) {
                cur.children[chNum] = new TrieNode();
            }
            cur = cur.children[chNum];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        return bfs(cur, word, 0);
    }

    private boolean bfs(TrieNode node, String word, int index){
        for (int i = index; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for(int j = 0; j < 26; j++){
                    if(node.children[j] != null){
                        boolean result = bfs(node.children[j], word, i + 1);
                        if(result == true){
                            return true;
                        }
                    }
                }
                return false;
            }else {
                if(node.children[word.charAt(i) - 'a'] == null){
                    return false;
                }else {
                    node = node.children[word.charAt(i) - 'a'];
                }
            }
        }
        return node.endOfWord;
    }

}
