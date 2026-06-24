import java.util.LinkedList;
import java.util.Queue;

public class StackQueueDequeueFriendly {

    Queue<Integer> pushQueue = new LinkedList<>();
    Queue<Integer> popQueue = new LinkedList<>();

    public void push(int data) {
        pushQueue.add(data);
    }

    public int pop() {
        if (pushQueue.isEmpty()) {
            return -1;
        }

        while (pushQueue.size() > 1) {
            popQueue.add(pushQueue.remove());
        }

        int value = pushQueue.remove();

        Queue<Integer> temp = pushQueue;
        pushQueue = popQueue;
        popQueue = temp;

        return value;
    }

    public static void main(String[] args) {
        StackQueueDequeueFriendly s = new StackQueueDequeueFriendly();

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
