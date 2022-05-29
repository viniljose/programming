package strings;

public class BackspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length()-1,j=t.length()-1;
        int skips=0,skipt=0;
        while(i>=0 || j>=0){
            while(i>=0){
                if(s.charAt(i)=='#'){
                    i--;
                    skips++;
                } else if (skips>0){
                    i--;
                    skips--;
                } else 
                break;
            }
            while(j>=0){
                if(t.charAt(i)=='#'){
                    j--;
                    skipt++;
                } else if (skipt>0){
                    j--;
                    skipt--;
                } else 
                break;
            }
            if(i>=0 && j>=0 && s.charAt(i)!=t.charAt(j))
            return false;
            if ((i >= 0) != (j >= 0))
                return false;
            i--;j--;    
        }
        return true;
    }
}
