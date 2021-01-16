package algorithm.problems.baekjoon.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Problem_1158 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
    
        List<Integer> qu = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            qu.add(i);
        }
        
        int[] answer = new int[N];
        int elmIndex = K - 1;
        int idx = 0;
        while (!qu.isEmpty()) {
            if (elmIndex + K < qu.size()) {
                answer[idx] = qu.remove(elmIndex);
                elmIndex += K;
            } else {
                answer[idx] = qu.remove(elmIndex);
                elmIndex = (elmIndex + K) - qu.size();
            }
            idx++;
        }
    
        System.out.println(Arrays.toString(answer));
    }
}
