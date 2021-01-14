package algorithm.problems.programmers.catetories.greedy.lifeBoat;

import java.util.*;

public class LifeBoat {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        Solution s = new Solution();
        System.out.println(s.solution(people, limit));
    }
}

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int min = 0;
        for (int max = people.length - 1; min <= max; max--) {
            if (people[min] + people[max] <= limit) min++;
            answer++;
        }

        return answer;
    }
}