package algorithm.problems.programmers.problems.level1.crane;

import java.util.Stack;

public class Crane {

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2},
            {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        Solution s = new Solution();
        System.out.println(s.solution(board, moves));
    }
}

class Solution {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int length = board.length;
        Stack<Integer> basket = new Stack<>();
        for (int i : moves) {
            int idx = i - 1;
            for (int j = 0; j < length; j++) {
                int selected = board[j][idx];
                if (selected != 0) {
                    if (basket.isEmpty()) {
                        basket.push(selected);
                    } else {
                        if (basket.peek() == selected) {
                            basket.pop();
                            answer += 2;
                        } else {
                            basket.push(selected);
                        }
                    }
                    board[j][idx] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}