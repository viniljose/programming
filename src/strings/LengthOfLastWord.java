package strings;

/**
 * https://leetcode.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWord len = new LengthOfLastWord();
        System.out.println(len.lengthOfLastWord("Hello World"));
        System.out.println(len.lengthOfLastWord("Hello World is"));
        System.out.println(len.lengthOfLastWord("Hello"));
        System.out.println(len.lengthOfLastWord(""));
        System.out.println(len.lengthOfLastWord(" "));
        System.out.println(len.lengthOfLastWord("  "));
        System.out.println(len.lengthOfLastWord("a "));
        System.out.println(len.lengthOfLastWord("i am vinil "));
    }

    public int lengthOfLastWord(String s) {
        if(s == null || s.equals(""))
            return 0;
        int len = s.length();
        int result = 0;
        boolean isChr = false;
        for(int i=len-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z' || ch >='A' && ch <='Z') {
                isChr = true;
                result++;
            } else {
             if(isChr){
                 return result;
                }
            }
        }
        return result;

    }
    public int lengthOfLastWord1(String s) {
        // trim the trailing spaces
        int p = s.length() - 1;
        while (p >= 0 && s.charAt(p) == ' ') {
            p--;
        }

        // compute the length of last word
        int length = 0;
        while (p >= 0 && s.charAt(p) != ' ') {
            p--;
            length++;
        }
        return length;
    }

}
