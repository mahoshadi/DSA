public class UnboundedArrayStack {
    int[] array = new int[4];
    int top = 0;

    public void push(int x) {
        if (top == array.length) {
            resize(array.length * 2);
        }
        array[top++] = x;
    }

    public int pop() {
        int val = array[--top];
        if (top > 0 && top <= array.length / 4) {
            resize(array.length / 2);
        }
        return val;
    }

    private void resize(int newSize) {
        int[] newArray = new int[newSize];
        for (int i = 0; i < top; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public static void main(String[] args) {
        UnboundedArrayStack s = new UnboundedArrayStack();
        s.push(1); s.push(2); s.push(3); s.push(4); s.push(5);
        System.out.println("Popped: " + s.pop());
    }
}
