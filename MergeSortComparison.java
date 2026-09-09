import java.util.Scanner;

public class MergeSortComparison {

    static long comparisons = 0;

    static void merge(int[] a, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = a[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = a[mid + 1 + j];

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {

            comparisons++;

            if (L[i] <= R[j]) {
                a[k++] = L[i++];
            }
            else {
                a[k++] = R[j++];
            }
        }

        while (i < n1) {
            a[k++] = L[i++];
        }

        while (j < n2) {
            a[k++] = R[j++];
        }
    }

    static void mergeSort(int[] a, int left, int right) {

        if (left < right) {

            int mid = left + (right - left) / 2;

            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);

            merge(a, left, mid, right);
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

        mergeSort(a, 0, n - 1);

        System.out.print("Sorted array: ");

        for (int x : a)
            System.out.print(x + " ");

        System.out.println();

        System.out.println("Number of comparisons: " + comparisons);

        sc.close();
    }
}