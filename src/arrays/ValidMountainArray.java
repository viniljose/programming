package arrays;

/**
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * arr is a mountain array if and only if:
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 *
 * Input: arr = [2,1]
 * Output: false
 *
 * Input: arr = [0,3,2,1]
 * Output: true
 */
public class ValidMountainArray {
    public static void main(String[] args) {
        ValidMountainArray validMountainArray = new ValidMountainArray();
        System.out.println(validMountainArray.validMountainArray(new int[]{0,3,2,1}));
        System.out.println(validMountainArray.validMountainArray(new int[]{2,1}));
        System.out.println(validMountainArray.validMountainArray(new int[]{3,5,5}));
        System.out.println(validMountainArray.validMountainArray(new int[]{0,1,2,3,4,5,6,7,8,9}));
        System.out.println(validMountainArray.validMountainArray(new int[]{9,8,7,6,5,4,3,2,1,0}));
    }

    public boolean validMountainArray1(int[] arr) {
        int length = arr.length;
        if(length<3)
            return false;
        boolean up = true;
        for (int i = 0; i < length-1; i++) {
            if(arr[i] == arr[i+1]){
                return false;
            } else if (arr[i] > arr[i+1]){
                up = false;
            } else {
                if(!up)
                    return false;
            }
        }
        if(up)
            return false;
    return true;
    }

    public boolean validMountainArray(int[] A) {
        int N = A.length;
        int i = 0;

        // walk up
        while (i+1 < N && A[i] < A[i+1])
            i++;

        // peak can't be first or last
        if (i == 0 || i == N-1)
            return false;

        // walk down
        while (i+1 < N && A[i] > A[i+1])
            i++;

        return i == N-1;
    }

}
