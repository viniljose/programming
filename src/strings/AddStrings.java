package strings;

/**
 * https://leetcode.com/problems/add-strings/description/
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 *
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
 * You must also not convert the inputs to integers directly.
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        int carry = 0;
        while (len1>=0 || len2>=0){
            int x1 = len1>=0?num1.charAt(len1)-'0':0;
            int x2 = len2>=0?num2.charAt(len2)-'0':0;
            int value = (x1+x2+carry)%10;
            carry =  (x1+x2+carry)/10;
            result.append(value);
            len1--;
            len2--;
        }
        if(carry>=0)
            result.append(carry);
        return result.reverse().toString();
    }
}
