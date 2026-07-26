public class SelectionSort {

    public static void selectionSort(int[] array) {
        int length = array.length;

        for (int currentIndex = 0; currentIndex < length - 1; currentIndex++) {
            int minimumIndex = currentIndex;
            for (int scanIndex = currentIndex + 1; scanIndex < length; scanIndex++) {
                if (array[scanIndex] < array[minimumIndex]) {
                    minimumIndex = scanIndex;
                }
            }

            int temp = array[minimumIndex];
            array[minimumIndex] = array[currentIndex];
            array[currentIndex] = temp;
        }
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = {64, 25, 12, 22, 11};

        System.out.println("Original Array:");
        printArray(numbers);

        selectionSort(numbers);

        System.out.println("Sorted Array:");
        printArray(numbers);
    }
}
