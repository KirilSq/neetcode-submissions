class KthLargest {

    private PriorityQueue<Integer> maxheap;
    private int k;
    public KthLargest(int k, int[] nums) {
        maxheap = new PriorityQueue<>(k);
        this.k = k;
        for(int num : nums){
            this.add(num);
        }
    }
    
    public int add(int val) {
        if(maxheap.size() < k ){
            maxheap.offer(val);
        }else if (maxheap.peek() < val){
            maxheap.poll();
            maxheap.offer(val);
        }
        return maxheap.peek();
    }
}
