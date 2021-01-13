package java_basic.ch11_CollectionFrameworks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueEx {

    public static void main(String[] args) {
        Stack st = new Stack();
        Queue qu = new LinkedList();

        st.push("0");
        st.push("1");
        st.push("2");

        qu.offer("0");
        qu.offer("1");
        qu.offer("2");

        System.out.println("= Stack =");
        while (!st.empty()) {
            System.out.println(st.pop());
        }

        System.out.println("= Queue =");
        while (!qu.isEmpty()) {
            System.out.println(qu.poll());
        }
    }
}
