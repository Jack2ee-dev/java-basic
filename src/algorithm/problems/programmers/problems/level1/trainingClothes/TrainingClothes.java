package algorithm.problems.programmers.problems.level1.trainingClothes;

public class TrainingClothes {

    public static void main(String[] args) {
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};
        Solution s = new Solution();
        System.out.println(s.solution(n, lost, reserve));
    }
}

class Solution {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] students = new int[n];
        for (int l : lost) {
            students[l - 1]--;
        }

        for (int r : reserve) {
            students[r - 1]++;
        }

        for (int i = 0; i < students.length; i++) {
            if (students[i] < 0) {
                if (i == 0) {
                    if (students[i + 1] > 0) {
                        students[i]++;
                        students[i + 1]--;
                    }
                } else if (i == students.length - 1) {
                    if (students[i - 1] > 0) {
                        students[i]++;
                        students[i - 1]--;
                    }
                } else {
                    if (students[i - 1] > 0) {
                        students[i]++;
                        students[i - 1]--;
                    } else if (students[i + 1] > 0) {
                        students[i]++;
                        students[i + 1]--;
                    }
                }
            }
        }

        for (int student : students) {
            if (student >= 0) {
                answer++;
            }
        }

        return answer;
    }
}