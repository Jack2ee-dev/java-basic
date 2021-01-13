package algorithm.categories.sort;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {10, 2, 6, 4, 3, 7, 5};

        for (int i = 1; i < arr.length; i++) {
            int compared = arr[i];
            int aux = i - 1;

            while (aux >= 0 && arr[aux] > compared) {
                arr[aux + 1] = arr[aux];
                aux--;
            }
            arr[aux + 1] = compared;
        }
        printArr(arr);
    }

    public static void printArr(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
