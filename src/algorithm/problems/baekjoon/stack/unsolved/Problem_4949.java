package algorithm.problems.baekjoon.stack.unsolved;

import java.util.Scanner;
import java.util.Stack;

public class Problem_4949 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            String str = in.nextLine();
            if (str.equals(".")) {
                break;
            }
            String[] split = str.split("");
            Stack<String> st = new Stack<>();
            boolean complete = true;
            label:
            for (String s : split) {
                switch (s) {
                    case "(":
                    case "[":
                        st.push(s);
                        break;
                    case "]":
                        if (st.isEmpty()) {
                            complete = false;
                            break label;
                        } else if (!st.peek().equals("[")) {
                            complete = false;
                            break label;
                        } else {
                            st.pop();
                        }
                        break;
                    case ")":
                        if (st.isEmpty()) {
                            complete = false;
                            break label;
                        } else if (!st.peek().equals("(")) {
                            complete = false;
                            break label;
                        } else {
                            st.pop();
                        }
                        break;
                }
            }
            if (complete) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
