public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 0; i < prefix.length(); i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                String pre = strs[j];
                String cur = strs[j + 1];
                if (pre.length() == i || cur.length() == i || pre.charAt(i) != cur.charAt(i)) {
                    return pre.substring(0,i);
                }
            }
        }
        return prefix;
    }
}
