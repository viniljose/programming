package strings;

//https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1161/
//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
public class IndexOf {
    public static void main(String[] args) {
               IndexOf str = new IndexOf();
        System.out.println(str.strStr("mississippi","issip"));
    }

    public int strStr(String haystack, String needle) {
        if(needle.equals("") )
            return 0;
        if(haystack ==null  || haystack.equals("") || needle==null)
            return -1;


        int lenHay = haystack.length();
        int lenNee = needle.length();
        if (lenNee > lenHay)
            return -1;

        for(int i=0; i<lenHay;i++){
            if(i+lenNee>lenHay)
                return -1;
            int k=i;
            for(int j=0;j<lenNee;j++) {
                if (haystack.charAt(k) == needle.charAt(j)) {
                     if (j == lenNee - 1)
                        return i;
                    k++;
                } else {
                   break;
                }
            }
        }

        return -1;
    }

    public int strStr1(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
