public class LinkedListStack {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node top;

    public void push(int data) {
        Node newNode = new Node(data);

        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) {
            return -1;
        }

        int value = top.data;
        top = top.next;

        return value;
    }

    public void display() {
        Node temp = top;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println(stack.pop());

        stack.display();
    }
}
