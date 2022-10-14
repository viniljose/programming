package integer;

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger rev = new ReverseInteger();

      /*  System.out.println(rev.reverse(123) );
        System.out.println(rev.reverse(-123) );
        System.out.println(rev.reverse(120) );
        System.out.println(rev.reverse(0) );*/
        System.out.println((int)Math.pow(2,30)-1);
        System.out.println(1534236469);
        //System.out.println(Integer.MAX_VALUE/2);
                                       //2147483648
        System.out.println(rev.reverse(-2147483412) );
    }

    public int reverse(int x) {

        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
