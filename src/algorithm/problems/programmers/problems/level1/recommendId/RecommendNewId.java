package algorithm.problems.programmers.problems.level1.recommendId;

public class RecommendNewId {

    public static void main(String[] args) {
        String[] newIds = {
            "...!@BaT#*..y.abcdefghijklm",
            "z-+.^.",
            "=.=",
            "123_.def",
            "abcdefghijklmn.p"
        };
        for (String newId : newIds) {
            Solution s = new Solution();
            System.out.println(s.solution(newId));
        }
    }
}

class Solution {

    public String solution(String newId) {
        return appendUntilThree(
            removeMoreThanSixteen(
                addA(
                    regexPunctualFirstAndLast(
                        regexPunctual(
                            regex(
                                toLower(newId))
                        )
                    )
                )
            )
        );
    }

    private String toLower(String id) {
        return id.toLowerCase();
    }

    private String regex(String id) {
        return id.replaceAll("[^a-z0-9-_.]", "");
    }

    private String regexPunctual(String id) {
        return id.replaceAll("[.]+", ".");
    }

    private String regexPunctualFirstAndLast(String id) {
        return regexPunctualFirst(regexPunctualLast(id));
    }

    private String regexPunctualFirst(String id) {
        return id.replaceAll("^[.]", "");
    }

    private String regexPunctualLast(String id) {
        return id.replaceAll("[.]$", "");
    }

    private String addA(String id) {
        if (id.length() == 0) {
            return "a";
        }
        return id;
    }

    private String removeMoreThanSixteen(String id) {
        if (id.length() >= 16) {
            return regexPunctualLast(id.substring(0, 15));
        }
        return id;
    }

    private String appendUntilThree(String id) {
        if (id.length() <= 2) {
            char lastChar = id.charAt(id.length() - 1);
            StringBuilder idBuilder = new StringBuilder(id);
            while (idBuilder.length() < 3) {
                idBuilder.append(lastChar);
            }
            return idBuilder.toString();
        }
        return id;
    }
}