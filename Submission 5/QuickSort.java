public class QuickSort {

    public static void quickSort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int partitionIndex = partition(array, lowIndex, highIndex);

            quickSort(array, lowIndex, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, highIndex);
        }
    }

    private static int partition(int[] array, int lowIndex, int highIndex) {
        int pivot = array[highIndex];
        int smallerElementIndex = lowIndex - 1;

        for (int currentIndex = lowIndex; currentIndex < highIndex; currentIndex++) {
            if (array[currentIndex] <= pivot) {
                smallerElementIndex++;
                int temp = array[smallerElementIndex];
                array[smallerElementIndex] = array[currentIndex];
                array[currentIndex] = temp;
            }
        }

        int temp = array[smallerElementIndex + 1];
        array[smallerElementIndex + 1] = array[highIndex];
        array[highIndex] = temp;

        return smallerElementIndex + 1;
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = {10, 7, 8, 9, 1, 5};

        System.out.println("Original Array:");
        printArray(numbers);

        quickSort(numbers, 0, numbers.length - 1);

        System.out.println("Sorted Array:");
        printArray(numbers);
    }
}
