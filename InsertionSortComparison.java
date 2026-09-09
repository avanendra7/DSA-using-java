import java.util.Scanner;

public class InsertionSortComparison {

    static long comparisons = 0;

    static void insertionSort(int[] a) {

        for (int i = 1; i < a.length; i++) {

            int key = a[i];
            int j = i - 1;

            while (j >= 0) {

                comparisons++;

                if (a[j] > key) {
                    a[j + 1] = a[j];
                    j--;
                }
                else {
                    break;
                }
            }

            a[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        insertionSort(a);

        System.out.print("Sorted array: ");

        for (int x : a) {
            System.out.print(x + " ");
        }

        System.out.println();

        System.out.println("Number of comparisons: " + comparisons);

        sc.close();
    }
z