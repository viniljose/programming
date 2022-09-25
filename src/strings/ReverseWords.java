package strings;
//https://leetcode.com/problems/reverse-words-in-a-string/
public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords("the sky is blue"));
        System.out.println(reverseWords.reverseWords("  hello world  "));
        System.out.println(reverseWords.reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        StringBuilder spaceRemoved = trimSpaces(s);
        reverse(spaceRemoved,0,spaceRemoved.length()-1);
        reverseEachWord(spaceRemoved);
        return spaceRemoved.toString();
    }

    private StringBuilder trimSpaces(String s){
        int left =0,right =s.length()-1;
        while (left<=right && s.charAt(left)==' ') left++;
        while (left<=right && s.charAt(right)==' ') right--;
        StringBuilder sb = new StringBuilder();
        while (left<=right){
            char c = s.charAt(left);
            if(c !=' ')
                sb.append(c);
            else if(sb.charAt(sb.length()-1)!=' ')
                sb.append(c);
            left++;
        }
        return sb;
    }

    private void reverse(StringBuilder sb,int left, int right){
        while (left <right){
            char tmp = sb.charAt(left);
           sb.setCharAt(left++,sb.charAt(right));
           sb.setCharAt(right--,tmp);
        }
    }

    private void reverseEachWord(StringBuilder sb){
        int start =0, end =0,len=sb.length();
        while (start < len){
            while(end<len && sb.charAt(end)!=' ') end++;
            reverse(sb,start,end-1);
            start = end+1;
            end++;
        }
    }
}
