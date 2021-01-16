package algorithm.problems.baekjoon.datastructure;

import java.util.LinkedList;
import java.util.Scanner;

public class Problem_10845 {
    
    static final LinkedList<Integer> qu = new LinkedList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for (int i = 0; i < N; i++) {
            String command = sc.next();
            switch (command) {
                case "push":
                    int b = sc.nextInt();
                    push(b);
                    break;
                case "pop":
                    System.out.println(pop());
                    break;
                case "size":
                    System.out.println(size());
                    break;
                case "empty":
                    System.out.println(empty());
                    break;
                case "front":
                    System.out.println(front());
                    break;
                case "back":
                    System.out.println(back());
                    break;
                default:
            }
        }
    }
    
    static void push(int x) {
        qu.add(x);
    }
    
    static int pop() {
        if (qu.isEmpty()) {
            return -1;
        }
        return qu.poll();
    }
    
    static int size() {
        return qu.size();
    }
    
    static int empty() {
        if (qu.isEmpty()) {
            return 1;
        }
        return 0;
    }
    
    static int front() {
        if (qu.isEmpty()) {
            return -1;
        } else {
            return qu.peekFirst();
        }
    }
    
    static int back() {
        if (qu.isEmpty()) {
            return -1;
        } else {
            return qu.peekLast();
        }
    }
}
