package algorithm.problems.programmers.catetories.sort.hIndex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HIndex {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        Solution s = new Solution();
        System.out.println(s.solution(citations));
    }
}

class Solution {

    public int solution(int[] citations) {
        int answer = 0;
        List<Integer> citationList = new ArrayList<>();
        for (int citation: citations) {
            citationList.add(citation);
        }
        citationList.sort(Collections.reverseOrder());

        int hIndex = 0;
        for (int i = 0; i < citationList.size(); i++) {
            int cCnt = 0;
            int citation = citationList.get(i);
            for (int j = 0; j < citationList.size(); j++) {
                if (citationList.get(j) >= citation) {
                    cCnt++;
                }
            }
            if (cCnt >= citation && cCnt > hIndex) {
                hIndex = cCnt;
            }
        }

        return hIndex;
    }
}