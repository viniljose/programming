package strings;

//Implement an algorithm to determine if a string has all unique characters.
public class UniqueChars {

	public static void main(String[] args) {
		
		UniqueChars un = new UniqueChars();
			System.out.println("1----------->"+un.isUniqueChars("vinil"));
			System.out.println("1----------->"+un.isUniqueChars("abcd"));
	}
	
	private boolean isUniqueChars(String value) {
		if(value.length()>128)
			return false;
		boolean[] ascii = new boolean[128];
		for(int i=0;i<value.length();i++) {
			int chAscii = value.charAt(i);
			if(ascii[chAscii]) {
				return false;
			}
			ascii[chAscii]=true;
		}
		return true;
	}
}
