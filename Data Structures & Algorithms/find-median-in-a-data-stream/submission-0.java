class MedianFinder {
    PriorityQueue<Integer> lowerHalf;
    PriorityQueue<Integer> higherHalf;
    public MedianFinder() {
        lowerHalf = new PriorityQueue<>((a, b) -> Integer.compare(b,a));
        higherHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(lowerHalf.isEmpty() || num < lowerHalf.peek()){
            lowerHalf.offer(num);
        }else {
            higherHalf.offer(num);
        }
        if(Math.abs(lowerHalf.size() - higherHalf.size()) > 1){
            Queue<Integer> smaller = lowerHalf.size() < higherHalf.size() ? lowerHalf : higherHalf;
            Queue<Integer> bigger = smaller == lowerHalf ? higherHalf : lowerHalf;
            smaller.offer(bigger.poll());
        }

    }
    
    public double findMedian() {
        if((lowerHalf.size() + higherHalf.size()) % 2 == 0){
            return (lowerHalf.peek() + higherHalf.peek()) / 2.0;
        }else return lowerHalf.size() < higherHalf.size() ? higherHalf.peek() : lowerHalf.peek();
    }
}
