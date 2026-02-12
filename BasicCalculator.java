import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        char operator;

        System.out.println("Welcome to Basic Calculator!");
        
        System.out.print("Enter first number: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid number. Try again.");
            scanner.next();
        }
        num1 = scanner.nextDouble();

        System.out.print("Enter an operator (+, -, *, /): ");
        operator = scanner.next().charAt(0);

        System.out.print("Enter second number: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid number. Try again.");
            scanner.next();
        }
        num2 = scanner.nextDouble();

        double result = 0;
        boolean validOperation = true;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    validOperation = false;
                }
                break;
            default:
                System.out.println("Error: Invalid operator.");
                validOperation = false;
        }

        if (validOperation) {
            System.out.printf("Result: %.2f %c %.2f = %.2f%n", num1, operator, num2, result);
        }

        scanner.close();
    }
}
