public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome palindrome = new ValidPalindrome();
        System.out.println(palindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(palindrome.isPalindrome("race a car"));
        System.out.println(palindrome.isPalindrome(" "));
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
}
