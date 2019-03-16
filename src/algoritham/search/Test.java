package algoritham.search;

public class Test {

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int[] arr ={1,2,3,4,5,6,7,9,11,12,18,21};
		System.out.println("---->"+bs.search(arr, 7));
		System.out.println("---->"+bs.search(arr, 22));

	}

}
