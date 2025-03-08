import java.util.Stack;

public class PostfixCalc {
    // allowed operator types
    final private String[] OPERATORS = {"+", "-", "*", "/", "%"};

    public double calculate(String input) {
        Stack<Double> operands = new Stack<Double>();
        String[] equation;
        // split equation on spaces into array
        // multi-digit should contain spaces
        if (input.contains(" ")) {
            equation = input.split("\\s+");
        }
        // if no spaces, its single digit put into array
        else {
            //set array to same length as string
            equation = new String[input.length()];
            //loop through elements and put in array
            for (int i = 0; i < input.length(); i++) {
                equation[i] = String.valueOf(input.charAt(i));
            }
        }
        double top, next;
        for (String oper : equation) {
            if (isOperator(oper)) {
                    if (operands.size() < 2) {
                        throw new IllegalArgumentException("Too Many Operators");
                    }
                    //grab the top two char from the stack
                    //convert to int and use the Simplify method
                    top = operands.pop();
                    next = operands.pop();
                    //convert to solution to char and push to top of stack
                    operands.push(simplify(top, next, oper));
            }
            else {
                try {
                    operands.push(Double.parseDouble(oper));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid Number: " + oper);
                }
            }
        }
        if (operands.size() != 1) {
            throw new IllegalArgumentException("Invalid Expression");
        }
        return operands.pop();
    }
    //check if the character is an operator
    private boolean isOperator(String c) {
            for (String operator : OPERATORS) {
                if (c.equals(operator)) {return true;}
            }
            return false;
    }
    //evaluate expression based on operator type and return solution
    private double simplify(double top, double next, String operand) {
        switch (operand) {
            case "+" -> { return (next + top); }
            case "-" -> { return (next - top); }
            case "*" -> { return (next * top); }
            case "/" -> { return (next / top); }
            case "%" -> { return (next % top); }
            //if other operator throw error
            default ->
                throw new IllegalArgumentException("Unknown operator:" + operand);
        }
    }
}
