package strings;
public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome palindrome = new ValidPalindrome();
        System.out.println(palindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(palindrome.isPalindrome("race a car"));
        System.out.println(palindrome.isPalindrome(" "));
        
        System.out.println(palindrome.isPalindromeBetter("A man, a plan, a canal: Panama"));
        System.out.println(palindrome.isPalindromeBetter("race a car"));
        System.out.println(palindrome.isPalindromeBetter(" "));
    }

    //t:o(n) s:o(n)
    public boolean isPalindrome(String s) {
        if(s == null)
            return false;
        String trimmed = s.trim();
        if(trimmed.equals(""))
            return true;
        if(trimmed.length() ==1)
            return true;

        StringBuilder builder = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(Character.isLetterOrDigit(ch))
                builder.append(Character.toLowerCase(ch));
        }
        String original = builder.toString();
        String reverse = builder.reverse().toString();

        return original.equals(reverse);
    }
    
    //t:o(n) s:o(1)
    public boolean isPalindromeBetter(String s) {
        if(s == null)
            return false;
        if(s.equals(""))
            return true;
        if(s.length() ==1)
            return true;

        for(int i=0,j=s.length()-1;i<j;i++,j--){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while (i<j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
        }
        return true;
    }
}
