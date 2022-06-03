package recursion;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumber {
    public char[][] reversiblePairs = {
        {'0', '0'}, {'1', '1'}, 
        {'6', '9'}, {'8', '8'}, {'9', '6'}
    };
    
    public List<String> findStrobogrammatic(int n) {
        return generateStroboNumbers(n, n);
    }

    public List<String> generateStroboNumbers(int n, int finalLength) {
        //Base Cases
        if (n==0)
        return new ArrayList<>(List.of(""));
        
        if(n==1)
        return new ArrayList<>(List.of("0", "1", "8"));

        List<String> prevStroboNums = generateStroboNumbers(n - 2, finalLength);
        List<String> currStroboNums = new ArrayList<>();

        for (String prevStroboNum : prevStroboNums) {
            for (char[] pair : reversiblePairs) {
                if(pair[0]!='0' || n!=finalLength){
                    currStroboNums.add(pair[0]+prevStroboNum+pair[1]);
                }
            }
            
        }
        return currStroboNums;
    }
    
}
