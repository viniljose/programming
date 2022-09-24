package strings;
//https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1162/
//https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println(lcp.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(lcp.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(lcp.longestCommonPrefix(new String[]{"caa","","a","acb"}));
        System.out.println(lcp.longestCommonPrefix(new String[]{"flower","flower","flower","flower"}));
    }

    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if(strs==null || length==0){ return ""; }
        if(length==1) return strs[0];
        //finding minimum length string
        int minLength = strs[0].length();
        for(int a =1;a<length;a++){
            if(minLength>strs[a].length())
                minLength = strs[a].length();
        }
        if(minLength==0){ return ""; }
        for(int i=0;i<minLength;i++){
            for(int j=0;j<length-1;j++){
                String first = strs[j];
                String second = strs[j+1];
                if(first.charAt(i)!=second.charAt(i))
                    return first.substring(0,i);
            }
        }
        return strs[0].substring(0,minLength);
    }

    public String longestCommonPrefix1(String[] strs) {
        if(strs.length==0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty())return "";
            }
        }
        return prefix;
    }
}
