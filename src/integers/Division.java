package integers;

    
//https://leetcode.com/problems/divide-two-integers/solution/
//As there is no corresponding +Ve value for Integer.MIN_VALUE, we do subtractions with negative integers only.
public class Division {

    public int divide(int dividend, int divisor) {
        if(dividend==divisor)
            return 1;
        if(Integer.MIN_VALUE==dividend && divisor==-1)
            return Integer.MAX_VALUE;
        int negatives = 2;
        if(dividend>0){
            negatives--;
            dividend = -dividend;
        }
        if(divisor>0){
            negatives--;
            divisor = -divisor;
        }
        int quotient = 0;
        while (dividend-divisor<=0){
            quotient--;
            dividend-=divisor;
        }
        if(negatives!=1)
            quotient=-quotient;
        return quotient;
    }

    public static void main(String[] args) {
        Division division = new Division();
        System.out.println(division.divide(-2147483648,-2147483648));
    }
}
