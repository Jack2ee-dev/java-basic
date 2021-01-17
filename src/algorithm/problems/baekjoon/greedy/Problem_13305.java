package algorithm.problems.baekjoon.greedy;

import java.util.Scanner;

public class Problem_13305 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] dist = new int[N - 1];
        int[] prices = new int[N];
        
        String[] distInputs = sc.nextLine().split(" ");
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.parseInt(distInputs[i]);
        }
        
        String[] priceInputs = sc.nextLine().split(" ");
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Integer.parseInt(priceInputs[i]);
        }
        
        int answer = prices[0] * dist[0];
        int nowCity = 0;
        int nextCity = nowCity + 1;
        
        while (nextCity < N - 1) {
            if (prices[nowCity] < prices[nextCity]) {
                answer += prices[nowCity] * dist[nextCity];
            }
            else {
                answer += prices[nextCity] * dist[nextCity];
                nowCity = nextCity;
            }
            nextCity++;
        }
    
        System.out.println(answer);
    }
}
