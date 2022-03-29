package search;

public class SquareRoot {

    public int mySqrt(int x) {
        if(x<2) return x;

        int pivot,left=2,right=x/2;

        while (left<=right){
            pivot=left+ (right-left)/2;
            long num = (long)pivot*pivot;
            if(num==x)
                return pivot;
            else if(num < x)
                left = pivot +1;
            else
                right=pivot-1;
        }
        return right;
    }

    public static void main(String[] args) {
        SquareRoot squareRoot = new SquareRoot();
        System.out.println(squareRoot.mySqrt(9));
        System.out.println(squareRoot.mySqrt(16));
        System.out.println(squareRoot.mySqrt(25));
    }
}
