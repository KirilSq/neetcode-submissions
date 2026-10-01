class PrefixTree {
    PrefixTree[] children;
    boolean endOfWord;

    public PrefixTree() {
        children = new PrefixTree[26];
        endOfWord = false;
    }

    public void insert(String word) {
        PrefixTree cur = this;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                cur.children[word.charAt(i) - 'a'] = new PrefixTree();
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        PrefixTree cur = this;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        PrefixTree cur = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (cur.children[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            cur = cur.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}
