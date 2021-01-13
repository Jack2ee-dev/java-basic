package java_basic.ch6_OOP1;

public class FactorialTest {

    public static void main(String[] args) {
        System.out.println(factorial(8));
    }

    static long factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
