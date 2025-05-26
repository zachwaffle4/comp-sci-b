/**
 * Name: Zachary Harel
 * Project: Stack Evaluation Lab
 * Date: 12/9/24
 * Description:
 * Class that evaluates a mathematical expression in the form of a string.
 */

package stacks;

import java.util.Stack;

public class Evaluator {
    String expression;
    Stack<Integer> operands = new Stack<>();
    Stack<Character> operators = new Stack<>();

    public Evaluator(String expression) {
        this.expression = expression;
    }

    /**
     * Applies the operator to the two operands and pushes the result to the operand stack.
     * Technically this method is not needed, but it makes the code more readable
     * and allowed me to print intermediate steps while debugging.
     */
    public void operate() {
        int operand1 = operands.pop();
        int operand2 = operands.pop();
        char operator = operators.pop();
        int result = apply(operator, operand2, operand1);

        operands.push(result);
    }

    /**
     * Evaluates the expression and returns the result.
     * @return the result of the expression
     */
    public int evaluate() {
        int currentNum = 0;

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + Character.getNumericValue(c); //there is a better way to do this
            } else if (isOperator(c)) {
                if (currentNum != 0) {
                    operands.push(currentNum);
                    currentNum = 0;
                }

                operators.push(c);
            } else if (c == ')') { //after reaching a closing parenthesis,  evaluate the expression inside the parentheses
                if (currentNum != 0) {
                    operands.push(currentNum);
                    currentNum = 0;
                }

                while (!operators.isEmpty()) {
                    operate();
                }
            }
        }

        return operands.peek();
    }

    public String getExpression() {
        return expression;
    }

    /**
     * Applies the operator to the two operands and returns the result.
     * @throws IllegalArgumentException if the operator is not one of +, -, *, or /
     * @return the result of the operation
     */
    public static int apply(char operator, int operand1, int operand2) {
        return switch (operator) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            case '/' -> operand1 / operand2;
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }

    //checks if a character is an operator
    public static boolean isOperator(char c) {
        return "+-*/".contains(String.valueOf(c));
    }
}