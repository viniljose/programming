public class ReverseString {
    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char[] array = new char[]{'h','e','l','l','o'};
        reverseString.reverseString(array);
        System.out.println(array);

        char[] array1 = new char[]{'h','a','n','n','a','h'};
        reverseString.reverseString(array1);
        System.out.println(array1);
    }

    public void reverseString(char[] s) {
        int length = s.length;
        for(int i=0,j=length-1;i<j;i++,j--){
            char temp = s[j];
            s[j]=s[i];
            s[i] = temp;
        }

    }
}
