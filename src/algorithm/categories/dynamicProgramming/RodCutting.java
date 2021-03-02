package algorithm.categories.dynamicProgramming;

public class RodCutting {

    public static void main(String[] args) {

    }

    // recursively - exponential running time: 2^(length-1)
    public static int recurCutRod(int[] prices, int length) {
        if (length == 0) {
            return 0;
        }
        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= length; i++) {
            q = Math.max(q, prices[i] + recurCutRod(prices, length - i));
        }
        return q;
    }

    private static int[] aux;

    // top-down with memoization
    public static int memoizedCutRod(int[] prices, int length) {
        aux = new int[length];
        for (int i = 0; i <= length; i++) {
            aux[i] = Integer.MIN_VALUE;
        }
        return memoizedCutRodAux(prices, length);
    }

    // memoized version of recurCutRoad
    public static int memoizedCutRodAux(int[] prices, int length) {
        if (aux[length] >= 0) {
            return aux[length];
        }

        int q;
        if (length == 0) {
            q = 0;
        } else {
            q = Integer.MIN_VALUE;
            for (int i = 1; i <= length; i++) {
                q = Math.max(q, memoizedCutRodAux(prices, length - i));
            }
        }
        aux[length] = q;
        return q;
    }

    public static int bottomUpCutRod(int[] prices, int length) {
        aux = new int[length];
        aux[0] = 0;
        for (int i = 1; i <= length; i++) {
            int q = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                q = Math.min(q, prices[j] + aux[i - j]);
            }
            aux[i] = q;
        }
        return aux[length];
    }
}
