package java_basic.ch5_Array;

public class Exercise5_4 {

    public static void main(String[] args) {
        int[][] arr = {
            {5, 5, 5, 5, 5},
            {10, 10, 10, 10, 10},
            {20, 20, 20, 20, 20},
            {30, 30, 30, 30, 30}
        };

        int total = 0;
        double average = 0;

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                total += arr[i][j];
                count += 1;
            }
        }

        average = total / (float) count;
        System.out.println(total);
        System.out.println(average);
    }
}
