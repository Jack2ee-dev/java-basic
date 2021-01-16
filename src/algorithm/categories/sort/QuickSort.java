package algorithm.categories.sort;

import java.util.Arrays;

public class QuickSort {
    
    public static void main(String[] args) {
        quickSort(new int[]{2, 8, 7, 1, 3, 5, 6, 4});
    }
    
    private static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    
    private static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        
        int mid = partition(arr, low, high);
        sort(arr, low, mid-1);
        sort(arr, mid, high);
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];
        while (low <= high) {
            while (arr[low] < pivot) {
                low++;
            }
            while (arr[high] > pivot) {
                high--;
            }
            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        return low;
    }
    
    private static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
