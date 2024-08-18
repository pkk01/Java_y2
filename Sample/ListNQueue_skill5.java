import java.util.ArrayList;
import java.util.List;

class ListQueue<T> {
    private List<T> queue;

    public ListQueue() {
        queue = new ArrayList<>();
    }

    public void add(T element) {
        queue.add(element);
    }

    public T remove() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return queue.remove(0);
    }

    public T get(int index) {
        if (index < 0 || index >= queue.size()) {
            throw new IndexOutOfBoundsException("Index is not in range");
        }
        return queue.get(index);
    }

    public void set(int index, T element) {
        if (index < 0 || index >= queue.size()) {
            throw new IndexOutOfBoundsException("Index is not in range");
        }
        queue.set(index, element);
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}

public class ListNQueue_skill5 {
    public static void main(String[] args) {
        ListQueue<Integer> queue = new ListQueue<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Queue after adding elements: " + queue);
        System.out.println("Removed element: " + queue.remove());
        System.out.println("Queue after removing an element: " + queue);

        queue.set(1, 25);
        System.out.println("After setting element at index 1 to 25: " + queue);
        System.out.println("Element at index 0: " + queue.get(0));
    }
}