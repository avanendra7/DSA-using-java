import java.util.Scanner;

public class CharacterBST {

    static class Node {
        char data;
        Node left, right;

        Node(char data) {
            this.data = data;
        }
    }

    static Node insert(Node root, char data) {

        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        }
        else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    static void postOrder(Node root) {

        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Node root = null;

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        System.out.println("Enter characters:");

        for (int i = 0; i < n; i++) {
            root = insert(root, sc.next().charAt(0));
        }

        System.out.print("Post-order traversal: ");
        postOrder(root);

        sc.close();
    }
}