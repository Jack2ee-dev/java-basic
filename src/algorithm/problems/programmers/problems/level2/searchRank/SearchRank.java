package algorithm.problems.programmers.problems.level2.searchRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchRank {

    public static void main(String[] args) {
        String[] info = {
            "java backend junior pizza 150",
            "python frontend senior chicken 210",
            "python frontend senior chicken 150",
            "cpp backend senior pizza 260",
            "java backend junior chicken 80",
            "python backend senior chicken 50"
        };
        String[] query = {
            "java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200",
            "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150",
            "- and - and - and chicken 100",
            "- and - and - and - 150"
        };
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(info, query)));
    }
}

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        int[][] sanitizedInfo = new int[info.length][5];
        for (int i = 0; i < info.length; i++) {
            String[] split = info[i].split(" ");
            int lang = 0;
            int career = 0;
            int capa = 0;
            int sf = 0;
            int score = 0;
            for (int j = 0; j < split.length; j++) {
                lang = split[0].equals("cpp") ? -1 : (split[0].equals("java") ? 0 : 1);
                career = split[1].equals("backend") ? 1 : 0;
                capa = split[2].equals("senior") ? 1 : 0;
                sf = split[3].equals("chicken") ? 1: 0;
                score = Integer.parseInt(split[4]);
            }
            sanitizedInfo[i][0] = lang;
            sanitizedInfo[i][1] = career;
            sanitizedInfo[i][2] = capa;
            sanitizedInfo[i][3] = sf;
            sanitizedInfo[i][4] = score;
        }

        int[][] sanitizedQuery = new int[query.length][5];
        for (int i = 0; i < query.length; i++) {
            String re = query[i].replaceAll(" and", "");
            String[] split = re.split(" ");
            int lang = 0;
            int career = 0;
            int capa = 0;
            int sf = 0;
            int score = 0;
            for (int j = 0; j < split.length; j++) {
                lang = split[0].equals("cpp") ? -1 : (split[0].equals("java") ? 0 : (split[0].equals("python") ? 1 : 2));
                career = split[1].equals("backend") ? 1 : (split[1].equals("frontend") ? 0 : 2);
                capa = split[2].equals("senior") ? 1 : (split[2].equals("junior") ? 0 : 2);
                sf = split[3].equals("chicken") ? 1: (split[3].equals("pizza") ? 0 : 2);
                score = Integer.parseInt(split[4]);
            }
            sanitizedQuery[i][0] = lang;
            sanitizedQuery[i][1] = career;
            sanitizedQuery[i][2] = capa;
            sanitizedQuery[i][3] = sf;
            sanitizedQuery[i][4] = score;
        }

        for (int i = 0; i < sanitizedQuery.length; i++) {
            List<Integer> langApp = new ArrayList<>();
            int lang = sanitizedQuery[i][0];
            if (lang == 2) {
                for (int k = 0; k < sanitizedInfo.length; k++) {
                    langApp.add(k);
                }
            } else {
                for (int j = 0; j < info.length; j++) {
                    if (sanitizedInfo[j][0] == lang) {
                        langApp.add(j);
                    }
                }
            }

            int career = sanitizedQuery[i][1];
            if (career != 2) {
                for (int j = 0; j < langApp.size(); i++) {
                    if (sanitizedInfo[langApp.get(j)][1] != career) {
                        langApp.remove(i);
                    }
                }
            }

            int capa = sanitizedQuery[i][2];
            if (capa != 2) {
                for (int j = 0; j < langApp.size(); i++) {
                    if (sanitizedInfo[langApp.get(j)][2] != capa) {
                        langApp.remove(i);
                    }
                }
            }

            int sf = sanitizedInfo[i][3];
            if (sf != 2) {
                for (int j = 0; j < langApp.size(); i++) {
                    if (sanitizedInfo[langApp.get(j)][3] != sf) {
                        langApp.remove(i);
                    }
                }
            }

            int score = sanitizedInfo[i][4];
            int temp = 0;
            for (int j = 0; j < langApp.size(); j++) {
                if (sanitizedInfo[langApp.get(j)][4] >= score) {
                    temp += 1;
                }
            }

            answer[i] = temp;
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}