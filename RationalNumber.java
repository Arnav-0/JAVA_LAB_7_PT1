public class RationalNumber {
    private int numerator;
    private int denominator;

    public RationalNumber(int numerator, int denominator) throws ArithmeticException {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    public static RationalNumber add(RationalNumber r1, RationalNumber r2) {
        int lcm = lcm(r1.denominator, r2.denominator);
        int numeratorSum = (r1.numerator * (lcm / r1.denominator)) + (r2.numerator * (lcm / r2.denominator));
        return new RationalNumber(numeratorSum, lcm);
    }

    public static RationalNumber subtract(RationalNumber r1, RationalNumber r2) {
        int lcm = lcm(r1.denominator, r2.denominator);
        int numeratorDifference = (r1.numerator * (lcm / r1.denominator)) - (r2.numerator * (lcm / r2.denominator));
        return new RationalNumber(numeratorDifference, lcm);
    }

    public static RationalNumber multiply(RationalNumber r1, RationalNumber r2) {
        return new RationalNumber(r1.numerator * r2.numerator, r1.denominator * r2.denominator);
    }

    public static RationalNumber divide(RationalNumber r1, RationalNumber r2) throws ArithmeticException {
        if (r2.numerator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return new RationalNumber(r1.numerator * r2.denominator, r1.denominator * r2.numerator);
    }

    public static int compare(RationalNumber r1, RationalNumber r2) {
        double value1 = (double) r1.numerator / r1.denominator;
        double value2 = (double) r2.numerator / r2.denominator;
        return Double.compare(value1, value2);
    }

    private void reduce() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    public int abs() {
        return Math.abs(numerator) / Math.abs(denominator);
    }
};