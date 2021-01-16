package algorithm.problems.baekjoon.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Problem_1874 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Queue<Integer> seq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            seq.offer(sc.nextInt());
        }
        
        Queue<Integer> qu = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            qu.offer(i);
        }
        
        List<String> answer = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        while (!qu.isEmpty()) {
            if (st.isEmpty()) {
                st.add(qu.poll());
                answer.add("+");
            } else {
                if (!st.peek().equals(seq.peek())) {
                    st.add(qu.poll());
                    answer.add("+");
                } else {
                    while (!st.isEmpty() && st.peek().equals(seq.peek())) {
                        st.pop();
                        seq.poll();
                        answer.add("-");
                    }
                }
            }
        }
        
        while (!st.isEmpty()) {
            if (!st.pop().equals(seq.poll())) {
                System.out.println("NO");
                return;
            }
            answer.add("-");
        }
        
        for (String string : answer) {
            System.out.println(string);
        }
    }
}
