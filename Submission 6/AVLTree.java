import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {

    static class Node {
        int value;
        int height;
        Node left, right;

        Node(int value) {
            this.value = value;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public int height(Node n) {
        return n == null ? 0 : n.height;
    }

    public int height() {
        return height(root);
    }

    private int getBalance(Node root) {
        if (root == null) return 0;
        return height(root.left) - height(root.right);
    }

    private Node rotateRight(Node root) {
        Node x = root.left;
        Node st = x.right;

        x.right = root;
        root.left = st;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node rotateLeft(Node root) {
        Node y = root.right;
        Node st = y.left;

        y.left = root;
        root.right = st;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) return new Node(value);

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        } else {
            return root;
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int bf = getBalance(root);

        if (bf > 1 && value < root.left.value) {
            return rotateRight(root);
        }
        if (bf > 1 && value > root.left.value) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }
        if (bf < -1 && value > root.right.value) {
            return rotateLeft(root);
        }
        if (bf < -1 && value < root.right.value) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node root, int value) {
        if (root == null) return root;

        if (value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            Node inOrderSuccessor = getMin(root.right);
            root.value = inOrderSuccessor.value;
            root.right = deleteRec(root.right, inOrderSuccessor.value);
        }

        if (root == null) return root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int bf = getBalance(root);

        if (bf > 1 && getBalance(root.left) >= 0) {
            return rotateRight(root);
        }
        if (bf > 1 && getBalance(root.left) < 0) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }
        if (bf < -1 && getBalance(root.right) <= 0) {
            return rotateLeft(root);
        }
        if (bf < -1 && getBalance(root.right) > 0) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
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

    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        if (root == null) return false;
        if (root.value == value) return true;
        return value < root.value ? searchRec(root.left, value) : searchRec(root.right, value);
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
            Node current = q.poll();
            System.out.print(current.value + " ");
            if (current.left != null) q.add(current.left);
            if (current.right != null) q.add(current.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AVLTree avl = new AVLTree();

        int[] values = {10, 20, 30, 40, 50, 25, 5, 2, 4};
        for (int v : values) {
            avl.insert(v);
        }

        System.out.print("In-Order:    ");
        avl.inOrder();

        System.out.print("Pre-Order:   ");
        avl.preOrder();

        System.out.print("Post-Order:  ");
        avl.postOrder();

        System.out.print("Level-Order: ");
        avl.levelOrder();

        System.out.println("Search 25: " + avl.search(25));
        System.out.println("Min: " + avl.findMin());
        System.out.println("Max: " + avl.findMax());
        System.out.println("Height: " + avl.height());

        avl.delete(2);
        avl.delete(5);
        avl.delete(20);

        System.out.print("After deletions (In-Order): ");
        avl.inOrder();
    }
}
