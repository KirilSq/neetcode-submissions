class MinStack {
    List<Integer> stack;
    List<Integer> minStack;

    public MinStack() {
        this.stack = new LinkedList<>();
        this.minStack = new LinkedList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        minStack.add(Math.min(val,
        minStack.isEmpty() ? Integer.MAX_VALUE : minStack.getLast()));
    }
    
    public void pop() {
        stack.removeLast();
        minStack.removeLast();
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return minStack.getLast();
    }
}
