import java.util.Random;
import java.util.Scanner;

public class SelectionSortTime {

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
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

        selectionSort(data);

        long endTime = System.nanoTime();

        double timeMillis = (endTime - startTime) / 1_000_000.0;
        System.out.println("Execution time: " + timeMillis + " ms");

        sc.close();
    }
}
