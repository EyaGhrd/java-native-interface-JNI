public class Euler {

    static {
        System.loadLibrary("Euler");
    }

    public native double sinFromC(double x);

    public double sinFromJava(double x) {
        double result = 0;
        double term;
        int sign = 1;

        for (int n = 1; n <= 9; n += 2) {
            term = Math.pow(x, n) / factorial(n);
            result += sign * term;
            sign *= -1;
        }

        return result;
    }

    public double factorial(int num) {
        double fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Euler eulerSin = new Euler();
        double x = 1.0;

        long startJava = System.nanoTime();
        double resultJava = eulerSin.sinFromJava(x);
        long endJava = System.nanoTime();
        long javaTime = endJava - startJava;

        long startC = System.nanoTime();
        double resultC = eulerSin.sinFromC(x);
        long endC = System.nanoTime();
        long cTime = endC - startC;

        System.out.println("Sin(x) from Java: " + resultJava);
        System.out.println("Java function execution time: " + javaTime + " nanoseconds");
        System.out.println("Sin(x) from C: " + resultC);
        System.out.println("C function execution time: " + cTime + " nanoseconds");
    }
}
