public class Solution {
    public String decodeString(String s) {
        //cc
        if(s.length() == 0 || s == null){
            return s;
        }
        
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<String> resStack = new ArrayDeque<>();
        
        int index = 0;
        String res = "";
        
        while(index < s.length()){
            //if digit
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while(Character.isDigit(s.charAt(index))){
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;    
                }
                countStack.offerFirst(count);
            }
            //if "[",push characters to resStack
            else if(s.charAt(index) == '['){
                resStack.offerFirst(res);
                res = "";
                index++;
            }
            //if "]" pop res to StringBuilder
            else if(s.charAt(index) == ']') {
                StringBuilder sb = new StringBuilder(resStack.pollFirst());
                int time = countStack.pollFirst();
                for(int i = 0; i < time; i++){
                    sb.append(res);
                }
                res = sb.toString();
                index++;
            }
            //if is Character
            else {
                res += s.charAt(index++);
            }
        }
        
        return res;
    }
}
