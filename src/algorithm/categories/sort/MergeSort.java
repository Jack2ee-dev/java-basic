package algorithm.categories.sort;

public class MergeSort {

    static int[] buff;

    public static void main(String[] args) {
        int[] src = {22, 5, 11, 32, 120, 68, 70};
        mergeSort(src, src.length);
        for (int element : src) {
            System.out.print(element + " ");
        }
    }

    private static void mergeSort(int[] src, int length) {
        buff = new int[length];
        __mergeSort(src, 0, length - 1);
        buff = null;
    }

    private static void __mergeSort(int[] src, int start, int end) {
        if (start < end) {
            int pGoThrough;
            int j = 0;
            int mid = (start + end) / 2;
            int pBuff = 0;
            int pSrc = start;

            __mergeSort(src, pBuff, mid);
            __mergeSort(src, mid + 1, end);

            for (pGoThrough = start; pGoThrough <= mid; pGoThrough++) {
                buff[pBuff++] = src[pGoThrough];
            }

            while (pGoThrough <= end && j < pBuff) {
                src[pSrc++] = buff[j] < src[pGoThrough] ? buff[j++] : src[pGoThrough++];
            }

            while (j < pBuff) {
                src[pSrc++] = buff[j++];
            }
        }
    }
}
