import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPushFriendly {
    Queue<Integer> pushQueue = new LinkedList<>();
    Queue<Integer> popQueue = new LinkedList<>();

    public void push(int x) {
        pushQueue.add(x);
    }

    public int pop() {
        while (pushQueue.size() > 1) {
            popQueue.add(pushQueue.remove());
        }
        int top = pushQueue.remove();

        Queue<Integer> temp = pushQueue;
        pushQueue = popQueue;
        popQueue = temp;

        return top;
    }

    public static void main(String[] args) {
        QueueStackPushFriendly s = new QueueStackPushFriendly();
        s.push(3);
        s.push(5);
        System.out.println("Queue before pop: " + s.pushQueue);
        System.out.println("Popped: " + s.pop());
        System.out.println("Queue after pop: " + s.pushQueue);
    }
}
