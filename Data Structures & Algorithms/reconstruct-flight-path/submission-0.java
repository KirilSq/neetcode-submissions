class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjList = new HashMap<>();
        for(List<String> ticket : tickets) {
            adjList.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }
        Deque<String> stack = new ArrayDeque<>();
        List<String> result = new LinkedList<>();
        stack.push("JFK");
        while(!stack.isEmpty()){
            String cur = stack.peek();
            PriorityQueue<String> outgoing = adjList.get(cur);
            if(outgoing != null && !outgoing.isEmpty()){
                stack.push(outgoing.poll());
            }else {
                result.addFirst(stack.pop());
            }
        }
        return result;
    }
}
