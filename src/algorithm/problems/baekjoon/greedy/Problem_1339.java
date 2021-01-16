package algorithm.problems.baekjoon.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Problem_1339 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] inputs = new String[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = sc.nextLine();
        }
        
        Stack<Integer> numbers = new Stack<>();
        for (int i = 0; i <= 9; i++) {
            numbers.add(i);
        }
        
        Arrays.sort(inputs, (o1, o2) -> (o1.length() - o2.length()) * -1);
        
        int maxSize = inputs[0].length();
        for (int i = 1; i < inputs.length; i++) {
            StringBuilder filler = new StringBuilder();
            for (int j = 0; j < maxSize - inputs.length - 1; j++) {
                filler.append("*");
            }
            inputs[i] = filler.append(inputs[i]).toString();
        }
        
        Map<String, Integer> mapped = new HashMap<>();
        for (int i = 0; i < maxSize; i++) {
            for (String input : inputs) {
                String stringify = Character.toString(input.charAt(i));
                if (!stringify.equals("*")) {
                    if (!mapped.containsKey(stringify)) {
                        mapped.put(stringify, numbers.pop());
                    }
                }
            }
        }
        
        int answer = 0;
        for (String input : inputs) {
            for (int j = 0; j < input.length(); j++) {
                String stringify = Character.toString(input.charAt(j));
                if (!stringify.equals("*")) {
                    answer += mapped.get(stringify) * Math.pow(10, input.length() - 1 - j);
                }
            }
        }
        System.out.println(answer);
    }
}
