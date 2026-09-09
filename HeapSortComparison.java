import java.util.Scanner;

public class HeapSortComparison {

    static long comparisons = 0;

    static void heapify(int[] a, int n, int i) {

        int largest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n) {
            comparisons++;

            if (a[left] > a[largest]) {
                largest = left;
            }
        }

        if (right < n) {
            comparisons++;

            if (a[right] > a[largest]) {
                largest = right;
            }
        }

        if (largest != i) {

            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            heapify(a, n, largest);
        }
    }

    static void heapSort(int[] a) {

        int n = a.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        // Extract elements
        for (int i = n - 1; i > 0; i--) {

            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            heapify(a, i, 0);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        heapSort(a);

        System.out.print("Sorted array: ");

        for (int x : a)
            System.out.print(x + " ");

        System.out.println();

        System.out.println("Number of comparisons: " + comparisons);

        sc.close();
    }
}