package algoritham.sort;

/**
 * http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
 *If the array contains only one element or zero elements then the array is sorted.
 *If the array contains more than one element then:
 *    Select an element from the array. This element is called the "pivot element". For example select the element in the middle of the array.
 *    All elements which are smaller than the pivot element are placed in one array and all elements which are larger are placed in another array.
 *    Sort both arrays by recursively applying Quicksort to them.
 *    Combine the arrays.
 *Quicksort can be implemented to sort "in-place". This means that the sorting takes place in the array and that no additional array needs to be created.
 *
 *http://www.geeksforgeeks.org/quick-sort/
 *The key process in quickSort is partition(). Target of partitions is, given an array 
 *and an element x of array as pivot, put x at its correct position in sorted array 
 *and put all smaller elements (smaller than x) before x, and put all greater elements (greater than x)
 * after x. All this should be done in linear time.
 * @author vjose
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int arr[] = {10, 80, 30, 90, 40, 50, 70};
        int n = arr.length;
        QuickSort ob = new QuickSort();
        System.out.println("before sorting");
        ob.printArray(arr);
        ob.sort(arr, 0, n-1);
        System.out.println("sorted array");
        ob.printArray(arr);

	}
	
	private int partition(int[] arr,int low,int high){
		int pivot=arr[high];
		int lastSwappedIndex=low-1;
		for(int j=low;j<high;j++){
			if(arr[j]<=pivot){
				lastSwappedIndex++;
				int temp=arr[j];
				arr[j]=arr[lastSwappedIndex];
				arr[lastSwappedIndex]=temp;
				
			}
		}
		
		arr[high]=arr[lastSwappedIndex+1];
		arr[lastSwappedIndex+1]=pivot;
		return lastSwappedIndex+1;
		
	}
	
	private void sort(int[] arr,int low,int high){
		if(low<high){
			int pi=partition(arr,low,high);
			sort(arr,low,pi-1);
			sort(arr,pi+1,high);
		}
	}
	
	private void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

}
