class Solution {
    public boolean isPalindrome(String s) {
        String lcCopy = s.toLowerCase();
        int left = 0;
        int right = lcCopy.length() - 1;
        while (left < right) {
            while(left < lcCopy.length() && !isAlphanumeric(lcCopy.charAt(left))){
                left++;
            }
            while(right >= 0 && !isAlphanumeric(lcCopy.charAt(right))){
                right--;
            }

            if(left < right && lcCopy.charAt(left) != lcCopy.charAt(right)){
                return false;
            }

             left ++;
            right --;
        }
        return true;
    }

    private boolean isAlphanumeric(char ch) {
        return ( ch >= 'a' && ch <= 'z')
                || (ch >= 'A' && ch <= 'Z')
                || (ch >= '0' && ch <= '9');
    }
}
