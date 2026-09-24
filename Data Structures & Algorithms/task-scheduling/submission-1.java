class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char task : tasks) {
            cnt[task - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(26, (a, b) -> Integer.compare(b, a));
        for (int count : cnt) {
            if (count > 0) {
                maxHeap.add(count);
            }
        }
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;
            if(maxHeap.isEmpty()){
                time = q.peek()[0];
            }else {
                int count = maxHeap.poll();
                if(count > 1) {
                    q.offer(new int[]{time + n, count - 1});
                }
            }
            
            if(!q.isEmpty() && q.peek()[0] <= time){
                maxHeap.offer(q.poll()[1]);
            }
        }
        return time;
    }
}
