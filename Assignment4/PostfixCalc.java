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
        double right, left;
        for (String oper : equation) {
            if (isOperator(oper)) {
                    if (operands.size() < 2) {
                        throw new IllegalArgumentException("Too Many Operators");
                    }
                    //grab the right two char from the stack
                    //convert to double and use the Simplify method
                    right = operands.pop();
                    left = operands.pop();
                    //convert to solution to char and push to top of stack
                    //updated order to left, right for readability
                    operands.push(simplify(left, right, oper));
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
    //updated ordering of variables to left then right
    //renamed variables to left and right for better readability
    private double simplify(double left, double right, String operand) {
        switch (operand) {
            case "+" -> { return (left + right); }
            case "-" -> { return (left - right); }
            case "*" -> { return (left * right); }
            case "/" -> { return (left / right); }
            case "%" -> { return (left % right); }
            //if other operator throw error
            default ->
                throw new IllegalArgumentException("Unknown operator:" + operand);
        }
    }
}