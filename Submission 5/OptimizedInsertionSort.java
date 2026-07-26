public class OptimizedInsertionSort {

    public static void optimizedInsertionSort(int[] array) {
        int length = array.length;
        for (int currentIndex = 1; currentIndex < length; currentIndex++) {
            int key = array[currentIndex];

            int insertionPosition = binarySearch(array, key, 0, currentIndex - 1);
            for (int shiftIndex = currentIndex - 1; shiftIndex >= insertionPosition; shiftIndex--) {
                array[shiftIndex + 1] = array[shiftIndex];
            }

            array[insertionPosition] = key;
        }
    }

    private static int binarySearch(int[] array, int key, int lowIndex, int highIndex) {
        while (lowIndex <= highIndex) {
            int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
            if (key < array[middleIndex]) {
                highIndex = middleIndex - 1;
            } else {
                lowIndex = middleIndex + 1;
            }
        }
        return lowIndex;
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = {37, 23, 0, 17, 12, 72, 31, 46, 100, 88, 54};

        System.out.println("Original Array:");
        printArray(numbers);

        optimizedInsertionSort(numbers);

        System.out.println("Sorted Array:");
        printArray(numbers);
    }
}
