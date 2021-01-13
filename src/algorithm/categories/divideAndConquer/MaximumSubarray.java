package algorithm.categories.divideAndConquer;

public class MaximumSubarray {

    private static final int[] ARRAY = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15,
        -4, 7};
    private static int MAX_START_INDEX;
    private static int MAX_END_INDEX;

    public static void main(String[] args) {
        String sb = "By bruteForce: " + solveByBruteForce() + "\n"
            + "MAX_START_INDEX: " + MAX_START_INDEX + "\n"
            + "MAX_END_INDEX: " + MAX_END_INDEX;
        System.out.println(sb);
        System.out.println(solveByDivideAndConquer());
    }

    private static void init() {
        MAX_START_INDEX = 0;
        MAX_END_INDEX = ARRAY.length - 1;
    }

    private static int solveByBruteForce() {
        init();
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < ARRAY.length; i++) {
            int sum = 0;
            for (int j = i; j < ARRAY.length; j++) {
                sum += ARRAY[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    MAX_START_INDEX = i;
                    MAX_END_INDEX = j;
                }
            }
        }
        return maxSum;
    }

    private static int solveByDivideAndConquer() {
        init();
        return calculateMaxSum(0, ARRAY.length - 1);
    }

    private static int crossMaxSum(int start, int mid, int end) {
        int tempSum = 0;
        int leftMaxSum = Integer.MIN_VALUE;
        int rightMaxSum = Integer.MIN_VALUE;

        for (int i = mid; i >= start; i--) {
            tempSum += ARRAY[i];
            if (tempSum > leftMaxSum) {
                leftMaxSum = tempSum;
            }
        }

        tempSum = 0;
        for (int i = mid + 1; i <= end; i++) {
            tempSum += ARRAY[i];
            if (tempSum > rightMaxSum) {
                rightMaxSum = tempSum;
            }
        }
        return (leftMaxSum + rightMaxSum);
    }

    private static int calculateMaxSum(int start, int end) {
        if (start == end) {
            return ARRAY[start];
        }
        int mid = (start + end) / 2;
        int leftMaxSum = calculateMaxSum(start, mid);
        int rightMaxSum = calculateMaxSum(mid + 1, end);
        int crossMaxSum = crossMaxSum(start, mid, end);
        return max(leftMaxSum, rightMaxSum, crossMaxSum);
    }

    private static int max(int sum1, int sum2, int sum3) {
        return Math.max(Math.max(sum1, sum2), Math.max(sum2, sum3));
    }
}
