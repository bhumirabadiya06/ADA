import java.util.Scanner;
import java.util.Arrays;

public class SearchAlgorithms{

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input target
        System.out.print("Enter element to search: ");
        int target = sc.nextInt();

        // Linear Search
        int linearResult = linearSearch(arr, target);
        if (linearResult != -1) {
            System.out.println("Linear Search: Element found at index " + linearResult);
        } else {
            System.out.println("Linear Search: Element not found");
        }

        // Sort array for Binary Search
        Arrays.sort(arr);

        // Binary Search
        int binaryResult = binarySearch(arr, target);
        if (binaryResult != -1) {
            System.out.println("Binary Search: Element found at index " + binaryResult + " (in sorted array)");
        } else {
            System.out.println("Binary Search: Element not found");
        }

        sc.close();
    }
}
