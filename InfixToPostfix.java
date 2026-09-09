import java.util.Scanner;

public class InfixToPostfix {

    static char[] stack = new char[100];
    static int top = -1;

    static void push(char ch) {
        stack[++top] = ch;
    }

    static char pop() {
        return stack[top--];
    }

    static char peek() {
        return stack[top];
    }

    static boolean isEmpty() {
        return top == -1;
    }

    static int precedence(char ch) {

        if (ch == '^')
            return 3;

        if (ch == '*' || ch == '/' || ch == '%')
            return 2;

        if (ch == '+' || ch == '-')
            return 1;

        return 0;
    }

    static String convert(String exp) {

        String result = "";

        for (int i = 0; i < exp.length(); i++) {

            char ch = exp.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                result += ch;
            }

            else if (ch == '(') {
                push(ch);
            }

            else if (ch == ')') {

                while (!isEmpty() && peek() != '(') {
                    result += pop();
                }

                if (!isEmpty()) {
                    pop();
                }
            }

            else {

                while (!isEmpty()
                        && peek() != '('
                        && precedence(peek()) >= precedence(ch)) {

                    result += pop();
                }

                push(ch);
            }
        }

        while (!isEmpty()) {
            result += pop();
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter infix expression: ");
        String exp = sc.nextLine();

        System.out.println("Postfix expression: " + convert(exp));

        sc.close();
    }
}