package algorithm.problems.programmers.problems.level2.skillTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SkillTree {

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skillTree = {"BACDE", "CBADF", "AECB", "BDA"};
        Solution s = new Solution();
        System.out.println(s.solution(skill, skillTree));

    }
}

class Solution {

    public int solution(String skill, String[] skillTrees) {
        int answer = 0;
        List<IndividualSkillTree> individualSkillTrees = new ArrayList<>();
        for (String skillTree : skillTrees) {
            individualSkillTrees.add(new IndividualSkillTree(skill, skillTree));
        }

        for (IndividualSkillTree individualSkillTree : individualSkillTrees) {
            if (individualSkillTree.isSafe()) {
                answer++;
            }
        }
        return answer;
    }
}

class IndividualSkillTree {

    private final List<String> skills;
    private final List<String> skillsNeededAdvance;

    public IndividualSkillTree(String skills, String skillTrees) {
        this.skills = skillsList(skills);
        this.skillsNeededAdvance = filteredNeededAdvance(skills, skillTrees);
    }

    public boolean isSafe() {
        int skillNeededAdvanceSize = skillsNeededAdvance.size();
        if (skillNeededAdvanceSize == 0) {
            return true;
        }
        int[] orders = new int[skillNeededAdvanceSize];
        for (int i = 0; i < skillNeededAdvanceSize; i++) {
            orders[i] = skills.indexOf(skillsNeededAdvance.get(i));
        }

        boolean containsZero = false;
        for (int order : orders) {
            if (order == 0) {
                containsZero = true;
                break;
            }
        }

        if (!containsZero) {
            return false;
        }

        int prevOrder = 0;
        int nextOrder = 1;

        while (nextOrder < orders.length) {
            if (orders[prevOrder] > orders[nextOrder]
                || orders[nextOrder] - orders[prevOrder] != 1) {
                return false;
            }
            prevOrder++;
            nextOrder++;
        }

        return true;
    }

    private List<String> skillsList(String skills) {
        List<String> skillNeeded = new ArrayList<>();
        Collections.addAll(skillNeeded, skills.split(""));
        return skillNeeded;
    }

    private List<String> filteredNeededAdvance(String skills, String skillTrees) {
        List<String> filtered = new ArrayList<>();
        Collections.addAll(filtered, skillTrees.split(""));
        filtered.retainAll(skillsList(skills));
        return filtered;
    }
}