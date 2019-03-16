package algoritham.sort;
/**
 * http://www.geeksforgeeks.org/merge-sort/
 *  It divides input array in two halves, calls itself for the two halves and then merges the two 
 *  sorted halves. The merge() function is used for merging two halves.
 *   The merge(arr, l, m, r) is key process that assumes that arr[l..m] and arr[m+1..r] 
 *   are sorted and merges the two sorted sub-arrays into one.
 * @author vjose
 *
 */
public class MergeSort {
	
	public void mergeSort(int[] arr,int l,int r){
	
		if(l<r){
			int m= (r+l)/2;
			mergeSort(arr,l,m);
			mergeSort(arr,m+1,r);
			merge(arr,l,m,r);
		}
	}
	
	private void merge(int[] arr,int l,int m,int r){
		int n1=m-l+1;
		int n2=r-m;
		int[] temp1= new int[n1];
		int[] temp2= new int[n2];
		for(int i=0;i<n1;i++)
		temp1[i]=arr[l+i];
		for(int i=0;i<n2;i++)
			temp2[i]=arr[m+1+i];
		
		int i=0,j=0;
		int k=l;
		while((i<n1) && (j<n2)){
			if(temp1[i] <= temp2[j]){
				arr[k]=temp1[i];
				i++;
			} else {
				arr[k]=temp2[j];
				j++;
				}
			k++;
		}
		
		while(i<n1){
			arr[k]=temp1[i];
			i++;
			k++;
		}
		
		while(j<n2){
			arr[k]=temp2[j];
			j++;
			k++;
		}
		
	}
	
	private void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7};
		 MergeSort ob = new MergeSort();
        System.out.println("Given Array");
        ob.printArray(arr);
 
       
        ob.mergeSort(arr, 0, arr.length-1);
 
        System.out.println("\nSorted array");
        ob.printArray(arr);

	}

}
