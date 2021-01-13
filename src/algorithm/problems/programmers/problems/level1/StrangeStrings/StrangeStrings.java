package algorithm.problems.programmers.problems.level1.StrangeStrings;

public class StrangeStrings {

    public static void main(String[] args) {
        String string = "try   hello world";
        Solution s = new Solution();
        System.out.println(s.solution(string));

        int i = 100;
    }

}

class Solution {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.replaceAll("\\s+", " ");
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append(" ");
                index = 0;
            } else {
                if (index % 2 == 0) {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                } else {
                    sb.append(Character.toLowerCase(s.charAt(i)));
                }
                index++;
            }
        }
        return sb.toString();
    }
}
