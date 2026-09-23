class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap =
            new PriorityQueue<>(k, (a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i < points.length; i++) {
            int squaredDist = calcDistanceSquared(points[i]);
            if (maxHeap.size() < k) {
                maxHeap.offer(new int[]{squaredDist, i});
            } else if (maxHeap.peek()[0] > squaredDist) {
                maxHeap.poll();
                maxHeap.offer(new int[]{squaredDist, i});
            }
        }
        int heapSize = maxHeap.size();
        int[][] result = new int[heapSize][2];
        for(int i=0; i < heapSize; i++){
            int pointIndex = maxHeap.poll()[1];
            result[i] = points[pointIndex].clone();
        }
        return result;
    }
    private int calcDistanceSquared(int[] points) {
        return points[0] * points[0] + points[1] * points[1];
    }
}
