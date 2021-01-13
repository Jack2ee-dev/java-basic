package algorithm.problems.programmers.catetories.stackQueue.stockPrice;

public class StockPrice {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        for (int an : solution(prices)) {
            System.out.print(an + " ");
        }
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    answer[i]++;
                    break;
                }
                answer[i]++;
            }
        }
        return answer;
    }
}
