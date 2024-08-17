
public class QueueGenerics<T> {
    private Node<T> front;
    private Node<T> rear;

    private static class Node<T> {
        private T data; // data part
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public void Queue() {
        front = rear = null;
    }

    public void enqueue(T item) {
        Node<T> node = new Node<>(item);
        if (rear != null) {
            rear.next = node;
        }
        rear = node;
        if (front == null) {
            front = rear;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        T item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public static void main(String[] args) {
        QueueGenerics<Integer> q = new QueueGenerics<>();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        System.out.println("Front Element: " + q.peek());
        System.out.println("Dequeued Element: " + q.dequeue());
        System.out.println("After dequeued, front Element: " + q.peek());
    }
}
