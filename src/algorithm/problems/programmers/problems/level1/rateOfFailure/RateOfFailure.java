package algorithm.problems.programmers.problems.level1.rateOfFailure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RateOfFailure {

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(N, stages)));
    }
}

class Solution {

    public int[] solution(int N, int[] stages) {

        List<Stage> list = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            int now = 0;
            int clear = 0;

            for (int stage : stages) {
                if (i <= stage) {
                    clear += 1;
                }
                if (i == stage) {
                    now += 1;
                }
            }

            if (clear == 0) {
                list.add(new Stage(i, 0));
            } else {
                list.add(new Stage(i, (double) now / clear));
            }
        }

        list.sort(Stage::compareTo);
        return list.stream().mapToInt(Stage::getStage).toArray();
    }

    static class Stage implements Comparable<Stage> {

        private final int stage;
        private final double failureRate;

        public Stage(int stage, double failureRate) {
            this.stage = stage;
            this.failureRate = failureRate;
        }

        public int getStage() {
            return this.stage;
        }

        public double getFailureRate() {
            return this.failureRate;
        }

        @Override
        public int compareTo(Stage o) {
            if (this.failureRate != o.getFailureRate()) {
                if (this.failureRate > o.getFailureRate()) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                if (this.stage > o.getStage()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
}
