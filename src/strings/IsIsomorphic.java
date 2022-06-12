package strings;

import java.util.Arrays;

public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        int[] mappingS = new int[256];
        int[] mappingT = new int[256];
        Arrays.fill(mappingS,-1);
        Arrays.fill(mappingT,-1);

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(mappingS[c1]==-1 && mappingT[c2]==-1){
                mappingS[c1] = c2;
                mappingT[c2] = c1;
            } else if (!(mappingS[c1]==c2 && mappingT[c2]==c1)){
                return false;
            }
        }
        return true;
    }
}
