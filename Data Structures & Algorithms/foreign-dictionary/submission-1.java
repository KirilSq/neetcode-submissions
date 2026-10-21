class Solution {
    public String foreignDictionary(String[] words) {
        boolean[][] adjList = new boolean[26][26];
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                indegree[ch - 'a'] = 0;
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String root = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String neighbor = words[j];
                int minLen = Math.min(root.length(), neighbor.length());
                int k = 0;
                for (; k < minLen; k++) {
                    int rootChId = root.charAt(k) - 'a';
                    int neighborChId = neighbor.charAt(k) - 'a';
                    if (rootChId != neighborChId && !adjList[rootChId][neighborChId]) {
                        adjList[rootChId][neighborChId] = true;
                        indegree[neighborChId]++;
                        break;
                    } else if (rootChId != neighborChId) {
                        break;
                    }
                }
                if (k == minLen && root.length() > neighbor.length()) {
                    return "";
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
            for (int i = 0; i < 26; i++) {
                if (adjList[cur][i]) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }

        for (int degree : indegree) {
            if (degree > 0) {
                return "";
            }
        }

        return result.toString();
    }
}
