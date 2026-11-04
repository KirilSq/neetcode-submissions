class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> starStack = new ArrayDeque();
        Deque<Integer> openingStack = new ArrayDeque();
        char[] c = s.toCharArray();        
        for(int i=0; i<c.length; i++){
            if(c[i] == '('){
                openingStack.push(i);
            }else if(c[i] == '*'){
                starStack.push(i);
            }else {
                if(!openingStack.isEmpty()){
                    openingStack.pop();
                }else if(!starStack.isEmpty()) {
                    starStack.pop();
                }else {
                    return false;
                }
            }
        }
        while(!openingStack.isEmpty() 
        && !starStack.isEmpty()){
            int openingId = openingStack.pop();
            int starId = starStack.pop();
            if(openingId > starId){
                return false;
            }
        }
        return openingStack.isEmpty();
    }
}
