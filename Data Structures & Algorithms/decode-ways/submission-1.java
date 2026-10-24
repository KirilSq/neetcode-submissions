class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0) == '0'){
            return 0;
        }
        int curr = 1;
        int prev = 1;
        for(int i = 2; i <= n; i++){
            char currCh = s.charAt(i-1);
            char prevCh = s.charAt(i-2);
            int bucket = 0;
            if(isViableDecoding(prevCh, currCh)){
                bucket+=prev;
            }
            if(isViableDecoding(currCh)){
                bucket+=curr;
            }
            prev = curr;
            curr = bucket;
        }
        return curr;
    }

    private boolean isViableDecoding(char ch1, char ch2){
        return ch1 == '1' ||
        ch1 == '2' && ch2 >= '0' && ch2 <= '6';
    }

    private boolean isViableDecoding(char ch){
        return ch != '0';
    }
    
}
