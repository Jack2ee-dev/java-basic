package algorithm.problems.programmers.catetories.dfsBfs.network;

import java.util.LinkedList;
import java.util.Queue;

public class Network {

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1},
        };
        Solution s = new Solution();
        System.out.println(s.solution(n, computers));
    }
}

class Solution {

    private static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(n, i, computers);
                answer++;
            }
        }

        return answer;
    }

    private void bfs(int n, int idx, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        visited[idx] = true;

        while (!q.isEmpty()) {
            int polledIdx = q.poll();
            visited[polledIdx] = true;
            for (int j = 0; j < n; j++) {
                if (computers[polledIdx][j] == 1 && !visited[j]) {
                    q.offer(j);
                }
            }
        }
    }
}

