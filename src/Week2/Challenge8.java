package Week2;

import java.util.Arrays;
interface SortingAlgorithm {
    int[] sortingAlgorithm(int[] arr);

}

class BubbleSortingAlgo implements SortingAlgorithm {
    @Override
    public int[] sortingAlgorithm(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
class MergeSortingAlgo implements SortingAlgorithm {

    @Override
    public int[] sortingAlgorithm(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public void merge(int[] arr, int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1];
        int[] M = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[p + i];
        }
        for (int j = 0; j < n2; j++) {
            M[j] = arr[q + 1 + j];
        }

        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }

    }
}

class QuickSortingAlgo implements SortingAlgorithm {

    @Override
    public int[] sortingAlgorithm(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    int partition(int[] a, int start, int end) {
        int pivot = a[end]; // pivot element
        int i = (start - 1);

        for (int j = start; j <= end - 1; j++) {
            if (a[j] < pivot) {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i + 1];
        a[i + 1] = a[end];
        a[end] = t;
        return (i + 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);  //p is partitioning index
            quickSort(arr, start, p - 1);
            quickSort(arr, p + 1, end);
        }
    }
}
public class Challenge8 {

    public static void main(String[] args) {
        int[] unsortedArray = {10, 6, 2, 66, 9, 15, 1, 6, 4};

        SortingAlgorithm bubbleSort = new BubbleSortingAlgo();
        int[] sortedByBubbleSort = bubbleSort.sortingAlgorithm(unsortedArray);

        SortingAlgorithm mergeSort = new MergeSortingAlgo();
        int[] sortedByMergeSort = mergeSort.sortingAlgorithm(unsortedArray);

        SortingAlgorithm quickSort = new QuickSortingAlgo();
        int[] sortedByQuickSort = quickSort.sortingAlgorithm(unsortedArray);

        System.out.println("Sorting array using Bubble Sort: " + Arrays.toString(sortedByBubbleSort));
        System.out.println("Sorting array using Merge Sort: " + Arrays.toString(sortedByMergeSort));
        System.out.println("Sorting array using Quick Sort: " + Arrays.toString(sortedByQuickSort));
    }

}
