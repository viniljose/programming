package strings;

public class LengthOfLongestSubstring {

    // brutforce method
    public int lengthOfLongestSubstring(String s) {
        int size = s.length();
        int length = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if(checkNoRepetition(s, i, j)){
                    length = Math.max(length,j-i+1);
                }
            }
        }
        return length;
    }

    private boolean checkNoRepetition(String s, int start, int end) {
        int[] chars = new int[128];
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            chars[c]++;
            if(chars[c]>1)
            return false;
        }
        return true;
    } 

    public static void main(String[] args){
        LengthOfLongestSubstring length = new LengthOfLongestSubstring();
        System.out.println(length.lengthOfLongestSubstring("abcabcbb"));
    }
}