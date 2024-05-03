import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first rational number:");
        int numerator1 = scanner.nextInt();
        int denominator1 = scanner.nextInt();
        RationalNumber r1;
        try {
            r1 = new RationalNumber(numerator1, denominator1);
        } catch (ArithmeticException e) {
            System.out.println("Invalid input: " + e.getMessage());
            return;
        }
        System.out.println("Enter the second rational number:");
        int numerator2 = scanner.nextInt();
        int denominator2 = scanner.nextInt();
        RationalNumber r2;
        try {
            r2 = new RationalNumber(numerator2, denominator2);
        } catch (ArithmeticException e) {
            System.out.println("Invalid input: " + e.getMessage());
            return;
        }
        System.out.println("Sum: " + RationalNumber.add(r1, r2));
        System.out.println("Difference: " + RationalNumber.subtract(r1, r2));
        System.out.println("Product: " + RationalNumber.multiply(r1, r2));
        try {
            System.out.println("Quotient: " + RationalNumber.divide(r1, r2));
        } catch (ArithmeticException e) {
            System.out.println("Invalid operation: " + e.getMessage());
        }
        System.out.println("Comparison: " + RationalNumber.compare(r1, r2));
    }
}