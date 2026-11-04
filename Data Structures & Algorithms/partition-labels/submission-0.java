class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastSeen = new int[26];
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            lastSeen[arr[i] - 'a'] = i;
        }
        List<Integer> result = new LinkedList<>();
        int l = 0;
        while(l < arr.length){
            int r = lastSeen[arr[l] - 'a'];
            for(int i=l; i <= r; i++){
                r = Math.max(r, lastSeen[arr[i] - 'a']);
            }
            result.addLast(r - l + 1);
            l = r + 1;
        }
        return result;
    }
}
