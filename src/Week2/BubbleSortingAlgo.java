package Week2;

public class BubbleSortingAlgo implements SortingAlgorithm {
        @Override
        public  void bubbleSort(int[] arr) {
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
        }

    /**
     * @param arr
     * @param start
     * @param end
     */
    @Override
    public void quickSort(int[] arr, int start, int end) {

    }

    /**
     * @param arr
     * @param left
     * @param right
     */
    @Override
    public void mergeSort(int[] arr, int left, int right) {

    }

    public static void main(String[] args) {
            BubbleSortingAlgo bubblesort = new BubbleSortingAlgo();
            int[] arr = {64, 34, 25, 12, 22, 11, 90};
            bubblesort.bubbleSort(arr);
            for(int i=0 ; i<arr.length ; i++) {
                System.out.println(arr[i]);
            }
        }

}
