public class NoOrderOfOperations {
    // strategy: recursively parse the expression

    // quirks reverse it first bebcause of the way stack evaluates
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder(args[0]);
        int solution = parseExpression(s.reverse().toString());
        System.out.println(solution);
        return;
    }

    public static int parseExpression(String expr) {
        if (expr.length() == 0) {
            return 0;
        }
        if (expr.length() == 1) {
            return Integer.parseInt(expr);
        }

        int operand = expr.charAt(0) - '0';
        char operator = expr.charAt(1);

        switch (operator) {
            case '+':  return operand + parseExpression(expr.substring(2, expr.length()));
            case '-':  return operand - parseExpression(expr.substring(2, expr.length()));
            case '*':  return operand * parseExpression(expr.substring(2, expr.length()));
            default: throw new IllegalArgumentException("Unrecognised operator " + operator);
        }
    }
}