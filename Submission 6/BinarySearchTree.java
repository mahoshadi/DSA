import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) return new Node(value);
        if (value < root.value) root.left = insertRec(root.left, value);
        else if (value > root.value) root.right = insertRec(root.right, value);
        return root;
    }

    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        if (root == null) return false;
        if (root.value == value) return true;
        return value < root.value ? searchRec(root.left, value) : searchRec(root.right, value);
    }

    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node root, int value) {
        if (root == null) return null;

        if (value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            Node minNode = getMin(root.right);
            root.value = minNode.value;
            root.right = deleteRec(root.right, minNode.value);
        }
        return root;
    }

    public Node getMin(Node root) {
        if (root == null) return null;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public int findMin() {
        Node minNode = getMin(root);
        return minNode == null ? -1 : minNode.value;
    }

    public int findMax() {
        if (root == null) return -1;
        Node curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr.value;
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.value + " ");
            inOrderRec(root.right);
        }
    }

    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.value + " ");
        }
    }

    public void levelOrder() {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.value + " ");
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
        System.out.println();
    }

    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(heightRec(node.left), heightRec(node.right));
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values) {
            bst.insert(v);
        }

        System.out.print("In-Order:    ");
        bst.inOrder();

        System.out.print("Pre-Order:   ");
        bst.preOrder();

        System.out.print("Post-Order:  ");
        bst.postOrder();

        System.out.print("Level-Order: ");
        bst.levelOrder();

        System.out.println("Min: " + bst.findMin());
        System.out.println("Max: " + bst.findMax());
        System.out.println("Search 40: " + bst.search(40));

        bst.delete(20);
        System.out.print("After delete 20 (In-Order): ");
        bst.inOrder();

        bst.delete(50);
        System.out.print("After delete 50 (In-Order): ");
        bst.inOrder();
    }
}
