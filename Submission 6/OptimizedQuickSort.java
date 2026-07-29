public class OptimizedQuickSort {

    private static final int THRESHOLD = 10;

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            if (high - low + 1 <= THRESHOLD) {
                insertionSort(arr, low, high);
                return;
            }

            int pIdx = medianOfThree(arr, low, high);
            swap(arr, low, pIdx);

            int pivot = arr[low];
            int lt = low, gt = high, i = low + 1;

            while (i <= gt) {
                if (arr[i] < pivot) {
                    swap(arr, lt++, i++);
                } else if (arr[i] > pivot) {
                    swap(arr, i, gt--);
                } else {
                    i++;
                }
            }

            quickSort(arr, low, lt - 1);
            quickSort(arr, gt + 1, high);
        }
    }

    private static int medianOfThree(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        if (arr[low] > arr[mid]) swap(arr, low, mid);
        if (arr[low] > arr[high]) swap(arr, low, high);
        if (arr[mid] > arr[high]) swap(arr, mid, high);
        return mid;
    }

    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {24, 9, 29, 14, 19, 27, 4, 1, 10, 15, 2, 7, 30, 22};
        System.out.print("Original: ");
        printArray(arr);

        sort(arr);

        System.out.print("Sorted:   ");
        printArray(arr);
    }
}
