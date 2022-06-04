package strings;
import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("()"));
        System.out.println(vp.isValid("()[]{}"));
        System.out.println(vp.isValid("(]"));
        System.out.println(vp.isValid("([)]"));
        System.out.println(vp.isValid("{[]}"));
        System.out.println(vp.isValid(""));
        System.out.println(vp.isValid("K"));
    }

    public boolean isValid(String s) {
        if (s==null || s.length()==0)
            return false;
        HashMap<Character,Character> values = new HashMap<Character,Character>();
        values.put('(',')');
        values.put('{','}');
        values.put('[',']');

        Stack<Character> stack = new Stack<Character>();

        for(int i=0;i<s.length();i++){
            Character current = s.charAt(i);
            if(values.containsKey(current)){
                stack.push(current);
            } else if (values.containsValue(current)){
                if(!stack.isEmpty() && values.get(stack.peek())==current){
                    stack.pop();
                } else {
                    return false;
                }

            } else {
                return false;
            }
        }
      return stack.isEmpty();
    }
}
