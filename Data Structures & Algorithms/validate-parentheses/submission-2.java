class Solution {
    public boolean isValid(String s) {
        Stack<Character> unpairedParentheses = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '{'  || curr == '(' || curr == '['){
                unpairedParentheses.push(curr);
            }else{
                if(unpairedParentheses.isEmpty() 
                        || unpairedParentheses.peek() == '{' && curr!='}'
                        || unpairedParentheses.peek() =='[' && curr!=']' 
                        || unpairedParentheses.peek() =='(' && curr !=')'){
                    return false;
                }else {
                    unpairedParentheses.pop();
                }
            }
        }
        return unpairedParentheses.isEmpty();
    }
    
}
