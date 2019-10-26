package arrays;

/**
 * Given an array of Integers,reorder it entries such that all even entries comes together.
 * Reference Elements of Programming Interviews
 *
 */
public class EvenOdd {
	
	public void rearrange(int[] array) {
		int evenPointer =0,oddPointer= array.length -1;
		while(evenPointer < oddPointer) {
			if(array[evenPointer]%2==0) {
				evenPointer++;
			} else {
				int temp = array[evenPointer];
				array[evenPointer] = array[oddPointer];
				array[oddPointer--] =temp; 
			}
		}
	}

	public static void main(String[] args) {
		EvenOdd even = new EvenOdd();
		int[] array = new int[] {1,5,4,7,8,9}; 
		even.rearrange(array);
		for(int i=0;i<array.length;i++)
		System.out.print(array[i]);
		
		System.out.println();
		
		 array = new int[] {7,2,2,3,6,0}; 
		even.rearrange(array);
		for(int i=0;i<array.length;i++)
		System.out.print(array[i]);

	}

}
