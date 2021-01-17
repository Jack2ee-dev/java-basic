package algorithm.problems.baekjoon.sort.unsolved;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Problem_1181 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            set.add(sc.nextLine());
        }
        
        List<String> sanitized = new ArrayList<>(set);
        sanitized.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) < o2.charAt(i)) {
                        return -1;
                    }
                }
            }
            
            return 0;
        });
        
        sanitized.forEach(System.out::println);
    }
}
