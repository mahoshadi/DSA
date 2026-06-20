import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPopFriendly {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.remove();
    }

    public static void main(String[] args) {
        QueueStackPopFriendly s = new QueueStackPopFriendly();
        s.push(10);
        s.push(20);
        System.out.println("Queue before pop: " + s.q1);
        System.out.println("Popped: " + s.pop());
        System.out.println("Queue after pop: " + s.q1);
    }
}
