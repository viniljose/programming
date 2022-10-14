package integer;

public class UglyNumber {
    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.isUgly(14));
    }
    public boolean isUgly(int n) {
        if (n < 1)
            return false;

        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
                continue;
            }
            if (n % 3 == 0) {
                n = n / 3;
                continue;
            }
            if (n % 5 == 0) {
                n = n / 5;
                continue;
            }
            return false;
        }
        return true;
    }
}
