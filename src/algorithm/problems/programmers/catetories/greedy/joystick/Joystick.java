package algorithm.problems.programmers.catetories.greedy.joystick;

import java.util.ArrayList;
import java.util.List;

public class Joystick {

    public static void main(String[] args) {
        String name = "BBBAAAB";
        Solution s = new Solution();
        System.out.println(s.solution(name));
    }
}

class Solution {
    public int solution(String name) {
        int answer = 0;
        List<NameChar> nameChars = new ArrayList<>();
        char[] nameLetter = name.toCharArray();
        for (int i = 0; i < nameLetter.length; i++) {
            nameChars.add(new NameChar(nameLetter[i], i));
        }

        int curPosition = 0;
        for (NameChar ch : nameChars) {
            if (ch.shortestDistanceFromA != 0) {
                answer += ch.shortestDistanceFromA + Integer.min(Math.abs(ch.index - curPosition), Math.abs(curPosition + nameChars.size() - ch.index));
                curPosition = ch.index;
            }
        }

        return answer;
    }
}

class NameChar {
    char nameChar;
    int shortestDistanceFromA;
    int index;

    public NameChar(char nameChar, int index) {
        this.nameChar = nameChar;
        this.shortestDistanceFromA = distance(nameChar);
        this.index = index;
    }

    private int distance(char nameChar) {
        if (nameChar - 'A' < 13) {
            return nameChar - 'A';
        } else {
            return 'Z' - nameChar + 1;
        }
    }
}