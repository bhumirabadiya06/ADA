import java.util.Random;
import java.util.Scanner;

public class InsertionSortTime {

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size * 10);
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements to sort: ");
        int size = sc.nextInt();

        int[] data = generateRandomArray(size);

        long startTime = System.nanoTime();

        insertionSort(data);

        long endTime = System.nanoTime();

        double timeMillis = (endTime - startTime) / 1_000_000.0;
        System.out.println("Execution time: " + timeMillis + " ms");

        sc.close();
    }
}
