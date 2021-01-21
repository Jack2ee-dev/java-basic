package algorithm.problems.programmers.problems.level2.searchBiggestSquare;

public class SearchBiggestSquare {

    public static void main(String[] args) {
        int[][] board = {
            {0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}
        };
        Solution s = new Solution();
        System.out.println(s.solution(board));
    }
}

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;

        int length = Integer.MIN_VALUE;
        int startIdx = 0;
        for (int i = 0; i < board.length; i++) {
            int temp = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    startIdx = i;
                    temp++;
                } else {
                    break;
                }
            }
            System.out.println(startIdx);
            System.out.println();
            if (temp > length) {
                length = temp;
            }
        }

        return answer;
    }
}