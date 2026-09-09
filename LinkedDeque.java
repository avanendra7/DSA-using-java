public class LinkedDeque {

    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node front = null;
    static Node rear = null;

    static void insertFront(int value) {

        Node newNode = new Node(value);

        if (front == null) {
            front = rear = newNode;
        }
        else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
    }

    static void insertRear(int value) {

        Node newNode = new Node(value);

        if (rear == null) {
            front = rear = newNode;
        }
        else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
    }

    static void deleteFront() {

        if (front == null) {
            System.out.println("Deque is empty");
            return;
        }

        System.out.println("Deleted: " + front.data);

        if (front == rear) {
            front = rear = null;
        }
        else {
            front = front.next;
            front.prev = null;
        }
    }

    static void deleteRear() {

        if (rear == null) {
            System.out.println("Deque is empty");
            return;
        }

        System.out.println("Deleted: " + rear.data);

        if (front == rear) {
            front = rear = null;
        }
        else {
            rear = rear.prev;
            rear.next = null;
        }
    }

    static void display() {

        Node temp = front;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
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