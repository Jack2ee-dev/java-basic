package algorithm.problems.programmers.catetories.dfsBfs.convertWord;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class ConvertWord {

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        Solution s = new Solution();
        System.out.println(s.solution(begin, target, words));

    }
}

class Solution {

    class Node {

        String next;
        int edge;

        public Node(String next, int edge) {
            this.next = next;
            this.edge = edge;
        }
    }


    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        q.add(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.next.equals(target)) {
                answer = node.edge;
                break;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isOneCharDifferent(node.next, words[i])) {
                    visited[i] = true;
                    q.offer(new Node(words[i], node.edge + 1));
                }
            }
        }
        return answer;
    }

    static boolean isOneCharDifferent(String base, String compared) {
        for (int i = 0; i < base.length(); i++) {
            StringBuilder beginReg = new StringBuilder(base);
            beginReg.setCharAt(i, '.');
            if (Pattern.matches(beginReg.toString(), compared)) {
                return true;
            }
        }
        return false;
    }
}