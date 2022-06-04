package strings;
public class Atoi {
    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        String s = "   -42";
        System.out.println(atoi.myAtoi(s));

        String s1 = "4193 with words";
        System.out.println(atoi.myAtoi(s1));

        String s2 = "+42";
        System.out.println(atoi.myAtoi(s2));

        String s3 = "42";
        System.out.println(atoi.myAtoi(s3));
    }

    public int myAtoi(String s) {
        int result = 0;
        int sign = 1;
        int index = 0;
        int length = s.length();

        // Discard all spaces from the beginning of the input string.
        while(index < length && (s.charAt(index)==' ')){
            index++;
        }

        // sign = +1, if it's positive number, otherwise sign = -1.
        if (index < length &&(s.charAt(index)=='+')){
            index++;
        } else if (index < length &&(s.charAt(index)=='-')){
            sign = -1;
            index++;
        }

        while (index < length && (Character.isDigit(s.charAt(index)))){
            int digit = s.charAt(index) -'0';

            // Check overflow and underflow conditions.
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result *10 + digit;
            index++;
        }

        return result*sign;

    }
}
