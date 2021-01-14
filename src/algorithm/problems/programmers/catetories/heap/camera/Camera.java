package algorithm.problems.programmers.catetories.heap.camera;

import java.util.Arrays;
import java.util.Comparator;

public class Camera {
    
    public static void main(String[] args) {
        int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
        Solution s = new Solution();
        System.out.println(s.solution(routes));
    }
}

class Solution {
    
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o -> o[0]));
        
        int answer = 1;
        int start = routes[0][0];
        int end = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            int in = routes[i][0];
            int out = routes[i][1];
            
            if (in > end || out < start) {
                answer++;
                start = in;
                end = out;
            } else {
                start = Math.max(start, in);
                end = Math.min(end, out);
            }
        }
        
        return answer;
    }
}