package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a array representing digits of +ve Integer, update the array to represent number +1
 * {1,2,3} ->{1,2,4}
 * (9,9,9) ->{1,0,0,0}
 *
 */
public class PlusOne {
	
	public List<Integer> plus(List<Integer> number){
		
		int last = number.size()-1;
		number.set(last, number.get(last)+1);
		for(int i=last;i>0&&number.get(i)==10;i--) {
			number.set(i-1, number.get(i-1)+1);
			number.set(i, 0);
		}
		if(number.get(0)==10) {
			number.set(0, 0);
			number.add(0,1);
		}
			
		
		return number;
		
	}

	public static void main(String[] args) {
		PlusOne plusOne = new PlusOne();
		List number = new ArrayList<Integer>(Arrays.asList(new Integer[] {1,2,9}));
		
		List result = plusOne.plus(number);
		
		result.forEach(value ->{
			System.out.print(value);
		});
		System.out.println();

 number = new ArrayList<Integer>(Arrays.asList(new Integer[] {9,9,9}));
		
		 result = plusOne.plus(number);
		
		result.forEach(value ->{
			System.out.print(value);
		});
		System.out.println();

		 number = new ArrayList<Integer>(Arrays.asList(new Integer[] {1,2,3}));
				
				 result = plusOne.plus(number);
				
				result.forEach(value ->{
					System.out.print(value);
				});
		
	}

}
