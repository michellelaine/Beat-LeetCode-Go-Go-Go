public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        
        int start = 0;
        int end = s.length() - 1;
        
        while(start < end) {
            //check left Valid
            while(start < s.length() && !isValid(s.charAt(start))) {
                start++;
            }
            
            //only "..,,,,," no alphanumeric input
            if(start == s.length()) {
                return true;
            }
            //check right valid
            while(end >= 0 && !isValid(s.charAt(end))) {
                end--;
            }
            
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                //break;
                return false;
            }else {
                start++;
                end--;
            }
        }
        return true;
    }
    
    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
