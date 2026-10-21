class Solution {
    public String foreignDictionary(String[] words) {
        boolean[][] adjList = new boolean[26][26];
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);

        int uniqueChars = 0;
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (indegree[ch - 'a'] == -1) {
                    indegree[ch - 'a'] = 0;
                    uniqueChars++;
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int minLen = Math.min(w1.length(), w2.length());
            for (int k = 0; k < minLen; k++) {
                int u = w1.charAt(k) - 'a';
                int v = w2.charAt(k) - 'a';
                if (u != v) {
                    if (!adjList[u][v]) {
                        adjList[u][v] = true;
                        indegree[v]++;
                    }
                    break; 
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!q.isEmpty()) {
            int cur = q.poll();
            result.append((char) (cur + 'a'));

            for (int next = 0; next < 26; next++) {
                if (adjList[cur][next]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
        }
        return result.length() == uniqueChars ? result.toString() : "";
    }
}
