package strings;

import java.util.*;

/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 * Given a string s, remove duplicate letters so that every letter appears once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * Input: s = "bcabc"
 * Output: "abc"
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 */
public class RemovingDuplicates {
    //Not working
    public String removeDuplicateLetters1(String s) {
        int length = s.length();
        Map<Character,Integer> letterCount = new HashMap();
        String result = "";
        for (int i = 0; i < length; i++) {
            char current = s.charAt(i);
            int count = letterCount.getOrDefault(current,0);
            letterCount.put(current,++count);
            if(count==1)
                result+=current;
        }
        System.out.println("1------->"+result);
        char[] chars = result.toCharArray();
        Arrays.sort(chars);
        result =  String.valueOf(chars);
        return result;
    }

    /**
     * The leftmost letter in our solution will be the smallest letter such that the suffix from that letter contains every other.
     *As we iterate over our string, if character i is greater than character i+1 and another occurrence of character i exists later in the string,
     * deleting character i will always lead to the optimal solution.
     */
    public String removeDuplicateLetters(String s) {
        //Solution is formed from this stack
        Stack<Character> stack = new Stack<>();

        //To track this already added element in stack
        Set<Character> seen = new HashSet<>();

        //Map to track last occurrence of the character
        HashMap<Character,Integer> lastOccurrence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            lastOccurrence.put(current,i);
        }

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(!seen.contains(current)){
                while(!stack.isEmpty() && current < stack.peek() && lastOccurrence.get(stack.peek())>i){
                    seen.remove(stack.pop());
                }
                stack.push(current);
                seen.add(current);
            }
        }
        StringBuilder result = new StringBuilder(stack.size());
        for(char c : stack)
            result.append(c);
        return result.toString();
    }
    public static void main(String[] args) {
        RemovingDuplicates dups = new RemovingDuplicates();
        System.out.println(dups.removeDuplicateLetters("bcabc"));
    }
}
