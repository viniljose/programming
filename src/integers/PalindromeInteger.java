package integer;

public class PalindromeInteger {
    public static void main(String[] args) {
        System.out.println(5/10);
        System.out.println(5%10);
        PalindromeInteger pal =new PalindromeInteger();
        System.out.println(pal.isPalindrome(122));
    }

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x <10) return true;
        int result = 0;
        int temp = x;
        while (temp != 0) {
            result = result*10 +temp%10;
            temp/=10;
        }
    return result==x;
    }
}
