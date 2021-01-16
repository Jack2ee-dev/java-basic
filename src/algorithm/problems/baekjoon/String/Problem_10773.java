package algorithm.problems.baekjoon.string;

import java.util.Scanner;
import java.util.Stack;

public class Problem_10773 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = Integer.parseInt(sc.nextLine());
    
        Stack<Integer> numbers = new Stack<>();
        for (int i = 0; i < K; i++) {
            String shout = sc.nextLine();
            if (shout.equals("0")) {
                numbers.pop();
            } else {
                numbers.add(Integer.parseInt(shout));
            }
        }
    
        if (numbers.size() < 1) {
            System.out.println(0);
            return;
        }
        
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println(sum);
        sc.close();
    }
}
