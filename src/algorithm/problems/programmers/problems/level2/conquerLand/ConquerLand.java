package algorithm.problems.programmers.problems.level2.conquerLand;

public class ConquerLand {

    public static void main(String[] args) {
        int[][] land = {
            {1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}
        };
        Solution s = new Solution();
        System.out.println(s.solution(land));
    }
}

class Solution {

    private int answer = 0;
    private int[][] arr;
    private boolean[][] visit;

    int solution(int[][] land) {
        arr = land;
        visit = new boolean[land.length][4];

        dfs(0, 0);

        return answer;
    }

    private void dfs(int depth, int score) {
        if (depth == arr.length) {
            if (answer < score) {
                answer = score;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (!visit[depth][i]) {
                visit[depth][i] = true;
                if (depth < arr.length - 1) {
                    visit[depth + 1][i] = true;
                }
                dfs(depth + 1, score + arr[depth][i]);
                visit[depth][i] = false;
                if (depth < arr.length - 1) {
                    visit[depth + 1][i] = false;
                }
            }
        }
    }
}