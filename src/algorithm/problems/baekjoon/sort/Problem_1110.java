package algorithm.problems.baekjoon.sort;

import java.util.Scanner;

public class Problem_1110 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        String[] numbers = new String[2];
        if (Integer.parseInt(N) < 10) {
            numbers[0] = "0";
            numbers[1] = N;
        } else {
            numbers[0] = Character.toString(N.charAt(0));
            numbers[1] = Character.toString(N.charAt(1));
        }
        
        int answer = 0;
        do {
            String sum = Integer
                             .toString(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
            numbers[0] = numbers[1];
            numbers[1] = Character.toString(sum.charAt(sum.length() - 1));
            answer++;
        } while (!N.equals(Integer.toString(Integer.parseInt(numbers[0] + numbers[1]))));
        System.out.println(answer);
    }
}
