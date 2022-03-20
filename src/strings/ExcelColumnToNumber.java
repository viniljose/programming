package strings;

import java.util.HashMap;
import java.util.Map;

public class ExcelColumnToNumber {
    public static void main(String[] args) {
        ExcelColumnToNumber excelColumnToNumber = new ExcelColumnToNumber();
        System.out.println(excelColumnToNumber.titleToNumber("AZZC"));
    }
    public int titleToNumber(String columnTitle) {
        int result = 0;
        Map<Character,Integer> alphabetMapping = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            int chr = i+65;
            alphabetMapping.put((char)chr,i+1);
        }
        int length = columnTitle.length();
        for (int i = 0; i < length; i++) {
            char letter = columnTitle.charAt(length-1 -i);
            result += alphabetMapping.get(letter)*Math.pow(26,i);
        }
        return result;
    }
}
