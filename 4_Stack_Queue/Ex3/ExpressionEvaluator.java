package Hw4_22000081_NguyenTienDat.Ex3;

import java.util.*;

public class ExpressionEvaluator  {
    public static boolean isBalanced(String expression) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                s.push(expression.charAt(i));
            } else if (expression.charAt(i) == ')') {
                if (s.isEmpty() || s.pop() != '(') {
                    return false;
                }
            }
        }
        return s.isEmpty();
    }

    public static double caculatorExpression(String expression) {
        if (!isBalanced(expression)){
            throw new IllegalArgumentException("invalid expression");
        }

        String[] expressionList = expression.split(" ");
        Stack<Double> number = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for (int i = 0; i < expressionList.length; i++) {
            String currentElement =  expressionList[i];
            if (Character.isDigit(currentElement.charAt(0))) {
                number.push(Double.parseDouble(currentElement));
            } else if (currentElement.charAt(0) == '(') {
                continue;
            } else if (currentElement.charAt(0) == ')') {
                double secondNum = number.pop();
                double firstNum = number.pop();
                char ope = operator.pop();
                number.push(caculator(firstNum, secondNum, ope));
            } else {
                operator.push(currentElement.charAt(0));
            }
        }

        if (!operator.isEmpty()) {
            while (operator.isEmpty()) {
                double secondNum = number.pop();
                double firstNum = number.pop();
                char ope = operator.pop();
                number.push(caculator(firstNum, secondNum, ope));
            }
        }
        return number.pop();
    }

    public static double caculator(double a, double b, char operator) {
        if (operator == '+') {
            return a + b;
        } else if (operator == '-') {
            return a - b;
        } else if (operator == '*') {
            return a * b;
        } else {
            if (b == 0) throw new ArithmeticException("Division by zero");
            return a / b;
        }
    }

    public static void main(String[] args) {
        String expression = "( 1 + ( ( 2 + 3 ) * ( 8 * 5 ) ) )";
        System.out.println(caculatorExpression(expression));
    }
}
