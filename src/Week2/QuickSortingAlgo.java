package Week2;

public class QuickSortingAlgo implements SortingAlgorithm {

    int partition (int[] a, int start, int end) {
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
        int t = a[i+1];
        a[i+1] = a[end];
        a[end] = t;
        return (i + 1);
    }

    @Override
    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);  //p is partitioning index
            quickSort(arr, start, p - 1);
            quickSort(arr, p + 1, end);
        }
    }

    @Override
    public void bubbleSort(int[] arr) {

    }
    @Override
    public void mergeSort(int[] arr, int left, int right) {

    }

    public static void main(String[] args) {
        int[] arr = { 13, 18, 27, 2, 19, 25 };
        int n = arr.length;

        QuickSortingAlgo q = new QuickSortingAlgo();
        q.quickSort(arr,0,n-1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
