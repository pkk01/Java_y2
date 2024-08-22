import java.util.PriorityQueue;
import java.util.Comparator;


public class PriorityQueueEx<T> {
    private PriorityQueue<T> queue;

    private PriorityQueueEx(Comparator<T> comp) {
        queue = new PriorityQueue<>(comp);
    }

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        return queue.poll();
    }

    public T peek() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Comparator<Integer> comparator = (a, b) -> b - a;
        PriorityQueueEx<Integer> pq = new PriorityQueueEx<>(comparator);
        pq.enqueue(152);
        pq.enqueue(142);
        pq.enqueue(122);
        pq.enqueue(112);
        pq.enqueue(23);
        System.out.println("Highest Priority element: " + pq.peek());
        System.out.println("Dequeue element: " + pq.dequeue());
        System.out.println("highest priority: " + pq.peek());
    }
}
