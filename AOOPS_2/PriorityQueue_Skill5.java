import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class PriorityQueue<T extends Comparable<T>> {
    private List<T> internalList;

    public PriorityQueue() {
        internalList = new ArrayList<>();
    }

    public void enqueue(T element) {
        int insertIndex = 0;
        for (T item : internalList) {
            if (item.compareTo(element) > 0) {
                break;
            }
            insertIndex++;
        }
        internalList.add(insertIndex, element);
    }

    public T dequeue() {
        if (internalList.isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty.");
        }
        return internalList.remove(0);
    }

    public T peek() {
        if (internalList.isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty.");
        }
        return internalList.get(0);
    }

    public int size() {
        return internalList.size();
    }

    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public String toString() {
        return internalList.toString();
    }
}

public class PriorityQueue_Skill5 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.enqueue(10);
        pq.enqueue(5);
        pq.enqueue(20);
        pq.enqueue(1);

        System.out.println("Priority Queue: " + pq);
        System.out.println("Peek: " + pq.peek());
        System.out.println("Dequeue: " + pq.dequeue());
        System.out.println("Priority Queue after dequeue: " + pq);
    }
}
