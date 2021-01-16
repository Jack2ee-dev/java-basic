package algorithm.problems.baekjoon.implementation;

import java.util.Scanner;

public class Problem_1475 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] inputs = sc.nextLine().split("");
        int[] numbers = new int[10];
        for (int i = 0; i < inputs.length; i++) {
            int input = Integer.parseInt(inputs[i]);
            if (input == 6 || input == 9) {
                if (numbers[6] > numbers[9]) {
                    numbers[9] += 1;
                } else {
                    numbers[6] += 1;
                }
            } else {
                numbers[input] += 1;
            }
        }
        
        int answer = 0;
        for (int i : numbers) {
            if (answer < i) {
                answer = i;
            }
        }
        
        System.out.println(answer);
    }
}
