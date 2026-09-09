
public class ArrayDeque {

    static int[] deque = new int[10];
    static int front = -1;
    static int rear = -1;
    static int size = 10;

    static boolean isEmpty() {
        return front == -1;
    }

    static boolean isFull() {
        return (front == 0 && rear == size - 1)
                || (front == rear + 1);
    }

    static void insertFront(int value) {

        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        }
        else if (front == 0) {
            front = size - 1;
        }
        else {
            front--;
        }

        deque[front] = value;
    }

    static void insertRear(int value) {

        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        }
        else if (rear == size - 1) {
            rear = 0;
        }
        else {
            rear++;
        }

        deque[rear] = value;
    }

    static void deleteFront() {

        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }

        System.out.println("Deleted: " + deque[front]);

        if (front == rear) {
            front = rear = -1;
        }
        else if (front == size - 1) {
            front = 0;
        }
        else {
            front++;
        }
    }

    static void deleteRear() {

        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }

        System.out.println("Deleted: " + deque[rear]);

        if (front == rear) {
            front = rear = -1;
        }
        else if (rear == 0) {
            rear = size - 1;
        }
        else {
            rear--;
        }
    }

    static void display() {

        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }

        int i = front;

        while (true) {
            System.out.print(deque[i] + " ");

            if (i == rear)
                break;

            i = (i + 1) % size;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        insertRear(10);
        insertRear(20);
        insertFront(5);
        insertFront(2);

        System.out.print("Deque: ");
        display();

        deleteFront();
        deleteRear();

        System.out.print("After deletion: ");
        display();
    }
}