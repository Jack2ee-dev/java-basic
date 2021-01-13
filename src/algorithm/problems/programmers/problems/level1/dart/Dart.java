package algorithm.problems.programmers.problems.level1.dart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Dart {

    public static void main(String[] args) {
        String dartResult = "1D2S3T*";
        Solution s = new Solution();
        System.out.println(s.solution(dartResult));
    }
}

class Solution {

    public int solution(String dartResult) {
        Score score = new Score();
        Queue<String> queue = new LinkedList<>(Arrays.asList(dartResult.split("")));
        Stack<Integer> numbers = new Stack<>();

        while (!queue.isEmpty()) {
            String polled = queue.poll();
            if (polled.equals("1")) {
                if (!queue.isEmpty() && queue.peek().equals("0")) {
                    polled += queue.poll();
                }
            }
            try {
                numbers.push(Integer.parseInt(polled));
            } catch (NumberFormatException e) {
                if (polled.equals("S")) {
                    score.singleScore(numbers.pop());
                }
                if (polled.equals("D")) {
                    score.doubleScore(numbers.pop());
                }
                if (polled.equals("T")) {
                    score.tripleScore(numbers.pop());
                }
                if (polled.equals("*")) {
                    score.star();
                }
                if (polled.equals("#")) {
                    score.acha();
                }
            }
        }

        return score.getTotal();
    }
}

class Score {

    private final List<Integer> scores = new ArrayList<>();

    public void singleScore(int score) {
        this.scores.add(score);
    }

    public void doubleScore(int score) {
        this.scores.add((int) Math.pow(score, 2));
    }

    public void tripleScore(int score) {
        this.scores.add((int) Math.pow(score, 3));
    }

    public void star() {
        int lastIdx = this.scores.size() - 1;
        int preScore = this.scores.get(lastIdx);
        this.scores.set(lastIdx, preScore * 2);
        if (this.scores.size() >= 2) {
            this.scores.set(lastIdx - 1, this.scores.get(lastIdx - 1) * 2);
        }
    }

    public void acha() {
        int lastIdx = this.scores.size() - 1;
        int preScore = this.scores.get(lastIdx);
        this.scores.set(lastIdx, preScore * -1);
    }

    public int getTotal() {
        int total = 0;
        for (int score : this.scores) {
            total += score;
        }
        return total;
    }
}
