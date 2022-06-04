package strings;

public class IsStrobogrammatic {
    public boolean isStrobogrammatic(String num) {
        int len = num.length();
        StringBuilder rotated = new StringBuilder();
        for (int i = len-1; i >=0 ; i--) {
            char number = num.charAt(i);
            if(number=='0'||number=='1'||number=='8'){
                rotated.append(number);
            } else if(number=='6'){
                rotated.append('9');
            }else if(number=='9'){
                rotated.append('6');
            } else {
                return false;
            }
        }
        return num.equals(rotated.toString());
    }
}
