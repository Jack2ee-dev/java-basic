package java_basic.ch5_Array;

public class ArrayEx3 {
    
    public static void main(String[] args) {
        int[] numbers = new int[10];

        for (int i = 0; i < 10; i++) {
            numbers[i] = i;
            System.out.print(numbers[i]);
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            int n = (int) (Math.random() * 10);
            int temp = numbers[0];
            numbers[0] = numbers[n];
            numbers[n] = temp;
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
        }
    }
}
