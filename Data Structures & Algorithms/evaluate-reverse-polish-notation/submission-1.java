class Solution {
    public int evalRPN(String[] tokens) {
        //validness is assumed
        Stack<Integer> stack = new Stack<>();
        for(String t : tokens){
            if(t.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(t.equals("-")){
                stack.push((-stack.pop()) + stack.pop());
            }else if(t.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(t.equals("/")){
                int r = stack.pop();
                int l = stack.pop();
                stack.push(l / r);
            }else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}
