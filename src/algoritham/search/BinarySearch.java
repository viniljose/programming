package algoritham.search;

public class BinarySearch {
	
	public boolean search(int[] arr, int element){
		if(arr==null || arr.length==0)
			return false;
		int low =0;
		int high=arr.length-1;
		
		while(low <= high){
			int mid = (high+low)/2;
			if(element==arr[mid]){
				return true;
			} else if(element<arr[mid]){
				high=mid-1;
			} else if(element>arr[mid]){
				low=mid+1;
			}
		}
		
		return false;
	}

}
