public class MergeSort {

    public static void mergeSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

            mergeSort(array, leftIndex, middleIndex);
            mergeSort(array, middleIndex + 1, rightIndex);

            merge(array, leftIndex, middleIndex, rightIndex);
        }
    }

    private static void merge(int[] array, int leftIndex, int middleIndex, int rightIndex) {
        int leftLength = middleIndex - leftIndex + 1;
        int rightLength = rightIndex - middleIndex;

        int[] leftSubarray = new int[leftLength];
        int[] rightSubarray = new int[rightLength];

        for (int i = 0; i < leftLength; i++) {
            leftSubarray[i] = array[leftIndex + i];
        }
        for (int j = 0; j < rightLength; j++) {
            rightSubarray[j] = array[middleIndex + 1 + j];
        }

        int leftPointer = 0;
        int rightPointer = 0;
        int mergedPointer = leftIndex;

        while (leftPointer < leftLength && rightPointer < rightLength) {
            if (leftSubarray[leftPointer] <= rightSubarray[rightPointer]) {
                array[mergedPointer] = leftSubarray[leftPointer];
                leftPointer++;
            } else {
                array[mergedPointer] = rightSubarray[rightPointer];
                rightPointer++;
            }
            mergedPointer++;
        }

        while (leftPointer < leftLength) {
            array[mergedPointer] = leftSubarray[leftPointer];
            leftPointer++;
            mergedPointer++;
        }

        while (rightPointer < rightLength) {
            array[mergedPointer] = rightSubarray[rightPointer];
            rightPointer++;
            mergedPointer++;
        }
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = {12, 11, 13, 5, 6, 7};

        System.out.println("Original Array:");
        printArray(numbers);

        mergeSort(numbers, 0, numbers.length - 1);

        System.out.println("Sorted Array:");
        printArray(numbers);
    }
}
