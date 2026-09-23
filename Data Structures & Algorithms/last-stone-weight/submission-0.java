class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(stones.length, (a, b) -> Integer.compare(b, a));
        for(int stone : stones){
            maxheap.offer(stone);
        }
        while(!maxheap.isEmpty()){
            int larger = maxheap.poll();
            Integer smaller = maxheap.poll();
            if(smaller == null){
                return larger;
            }
            larger-=smaller;
            if(larger!=0){
                maxheap.offer(larger);
            }
        }
        return 0;
    }
}
