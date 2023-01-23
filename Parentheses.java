import java.util.*;
import java.util.Scanner;

public class Parentheses {
    public static boolean isBalanced(String expr) {
        Deque<Character> parentStack = new ArrayDeque<>();

        for (int i = 0; i < expr.length(); i++) {
            char symbol = expr.charAt(i);

            if (symbol == '(' || symbol == '[' || symbol == '{') {
                parentStack.push(symbol);
                continue;
            }

            if (parentStack.isEmpty())
                return false;
            char checkSymbol;
            switch (symbol) {
                case ')':
                    checkSymbol = parentStack.pop();
                    if (checkSymbol == '{' || checkSymbol == '[')
                        return false;
                    break;

                case '}':
                    checkSymbol = parentStack.pop();
                    if (checkSymbol == '(' || checkSymbol == '[')
                        return false;
                    break;

                case ']':
                    checkSymbol = parentStack.pop();
                    if (checkSymbol == '(' || checkSymbol == '{')
                        return false;
                    break;
            }
        }
        return (parentStack.isEmpty());
    }

    // Driver code
    public static void main(String[] args) {
        System.out.println("This program checks if the parentheses, brackets, and braces are balanced.");
        System.out.println("Please enter a string:");
        Scanner s = new Scanner(System.in);
        String par = s.next();
        boolean t = isBalanced(par);
        if (t == true) {
            System.out.println("this string is balanced.");

        } else {
            System.out.println("this string is not balanced.");
        }
    }

}
