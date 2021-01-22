package algorithm.problems.baekjoon.queue.unsolved;

import java.util.LinkedList;
import java.util.Scanner;

public class Problem_5430 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int trial = Integer.parseInt(in.nextLine());
        while (true) {
            if (trial <= 0) {
                break;
            }
            trial--;
            String[] f = in.nextLine().split("");
            int n = Integer.parseInt(in.nextLine());

            String re = in.nextLine();
            String[] split = re.replaceAll("[\\[\\]]", "").split(",");
            LinkedList<Integer> qu = new LinkedList<>();
            for (String s : split) {
                try {
                    qu.offer(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                    System.out.println("error");
                    continue;
                }
            }
            boolean reverse = false;
            boolean error = false;
            for (String s : f) {
                if (s.equals("R")) {
                    reverse = !reverse;
                } else {
                    if (qu.isEmpty()) {
                        error = true;
                        break;
                    } else {
                        if (reverse) {
                            qu.pollLast();
                        } else {
                            qu.pollFirst();
                        }
                    }
                }
            }

            if (!error) {
                if (!reverse) {
                    System.out.print("[");
                    while (!qu.isEmpty()) {
                        if (qu.size() > 1) {
                            System.out.print(qu.poll() + ",");
                        } else {
                            System.out.print(qu.poll());
                        }
                    }
                    System.out.print("]");
                } else {
                    System.out.print("[");
                    while (!qu.isEmpty()) {
                        if (qu.size() > 1) {
                            System.out.print(qu.pollLast() + ",");
                        } else {
                            System.out.print(qu.pollLast());
                        }
                    }
                    System.out.print("]");
                }
                System.out.println();
            }
        }
    }
}
