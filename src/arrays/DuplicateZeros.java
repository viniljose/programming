package arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * Input: [1,0,2,3,0,4,5,0]
 * after [1,0,0,2,3,0,0,4]
 */
public class DuplicateZeros {
    public static void main(String[] args) {
        DuplicateZeros duplicateZeros = new DuplicateZeros();
        int[] input = new int[]{1,0,2,3,0,4,5,0};
        duplicateZeros.duplicateZeros(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]+",");
        }

        //Test 2
        int[] input2 = new int[]{0,0,0,0,0,0,0};
        duplicateZeros.duplicateZeros(input2);
        for (int i = 0; i < input2.length; i++) {
            System.out.print(input2[i]+",");
        }
    }

    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            if (arr[i] == 0){
                int j = len -2;
                while(j>=i+1){
                    arr[j+1]=arr[j];
                    j--;
                }
                arr[i+1]=0;
                i++;
            }
        }
    }
}
