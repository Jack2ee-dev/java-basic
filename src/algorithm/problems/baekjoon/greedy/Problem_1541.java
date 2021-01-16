package algorithm.problems.baekjoon.greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Problem_1541 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = (sc.nextLine() + "-").split("");
        
        Queue<String> tempNumbers = new LinkedList<>();
        List<String> operations = new ArrayList<>();
        List<Integer> operands = new ArrayList<>();
        
        tempNumbers.offer(inputs[0]);
        for (int i = 1; i < inputs.length; i++) {
            if (inputs[i].equals("-") || inputs[i].equals("+")) {
                operations.add(inputs[i]);
                StringBuilder tempNumber = new StringBuilder();
                while (!tempNumbers.isEmpty()) {
                    tempNumber.append(tempNumbers.poll());
                }
                operands.add(Integer.parseInt(tempNumber.toString()));
            } else {
                tempNumbers.offer(inputs[i]);
            }
        }
        
        int answer = 0;
        int firstMinusIdx = -1;
        for (int i = 0; i < operations.size() - 1; i++) {
            if (operations.get(i).equals("-")) {
                firstMinusIdx = i;
                break;
            }
        }
        
        if (firstMinusIdx < 0) {
            System.out.println(operands.stream().mapToInt(Integer::intValue).sum());
            return;
        }
        
        for (int i = 0; i <= firstMinusIdx; i++) {
            answer += operands.get(i);
        }
        
        for (int i = firstMinusIdx + 1; i < operands.size(); i++) {
            answer -= operands.get(i);
        }
        
        System.out.println(answer);
    }
}
