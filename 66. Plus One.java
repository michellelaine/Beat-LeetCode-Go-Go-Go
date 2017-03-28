/* 一刷
public class Solution {
    public int[] plusOne(int[] digits) {
        // if(digits == null || digits.length == 0) {
        //     return digits;
        // }
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--){
            if(digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0; 
        }
        
        int[] array = new int[len + 1];
        array[0] = 1;
        return array;
    }
}*/

//二刷
public class Solution {
    public int[] plusOne(int[] digits) {
        //carry = 1, when carry = 0 means no carry, finish
        int carry = 1;
        for(int i = digits.length - 1; i >= 0 && carry > 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if(carry == 0) {
            return digits;
        }
        
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        
        for(int i = 1; i < newDigits.length; i++){
            newDigits[i] = digits[i - 1];
        }
        return newDigits;
    }
}
