// Given a random String, check if its brackets (parenthesis - ({[]}))
// are balanced
// Example:
//
// "{(a,b)}" - balanced
// "{(a},b)" - not balanced
// "{)(a,b}" - not balanced
//

public class Solution {

    public static void main(String args[]) {

        System.out.println(isBalanced("{(a,b)}"));
        System.out.println(isBalanced("{(a},b)"));
        System.out.println(isBalanced("{)(a,b}"));
    }

    /**
    * We use a Stack. We loop through the String,
    * pushing into the Stack every time we find an opening
    * char ('[', '(', '{') and popping every time we find a closing char
    * (']', ')', '}'), unless the Stack is already empty which means the
    * String isn't balanced. If by the end of the for loop the stack is empty,
    * the String is balanced.
    */
    public static boolean isBalanced(String s) {
        Stack<Character> charStack  = new charStack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {
                charStack.push(c);
            } else if(c == ']') {
                if(charStack.isEmpty() || charStack.pop() != '[') {
                    return false;
                }
            } else if(c == ')') {
                if(charStack.isEmpty() || charStack.pop() != '(') {
                    return false;
                }
            } else if(c == '}') {
                if(charStack.isEmpty() || charStack.pop() != '{') {
                    return false;
                }
            }
        }
        return charStack.isEmpty();
    }
}
