package algorithm.categories.sort;

import java.util.Arrays;

public class HeapSort {
    
    public static void main(String[] args) {
        int[] numbers = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        heapSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
    
    static void heapSort(int[] arr) {
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, i, 0);
        }
    }
    
    static void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            maxHeapify(arr, arr.length, i);
        }
    }
    
    static void maxHeapify(int[] arr, int heapSize, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            swap(arr, largest, i);
            maxHeapify(arr, heapSize, largest);
        }
    }
    
    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}