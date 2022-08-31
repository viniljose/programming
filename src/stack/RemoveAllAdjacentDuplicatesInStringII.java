package stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from
 * s and removing them, causing the left and the right side of the deleted substring to concatenate together. *
 * We repeatedly make k duplicate removals on s until we no longer can. *
 * Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
 *
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 */
public class RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if(i==0 || sb.charAt(i)!=sb.charAt(i-1))
                stack.push(1);
            else {
                int count = stack.pop()+1;
                if(count==k){
                    //beginning of index inclusive, end of the index exclusive
                    sb.delete(i-k+1,i+1);
                    i=i-k;
                } else
                    stack.push(count);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInStringII remove = new RemoveAllAdjacentDuplicatesInStringII();
        System.out.println(remove.removeDuplicates("deeedbbcccbdaa",3));
    }
}
