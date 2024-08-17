import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackGenerics<T> {
    private List<T> stack;

    public StackGenerics() {
        stack = new ArrayList<>();
    }

    public void push(T element) {
        stack.add(element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        StackGenerics<Integer> stack = new StackGenerics<>();
        stack.push(12);
        stack.push(13);
        stack.push(14);

        System.out.println("Top element is: " + stack.peek());
        System.out.println("Size of stack is: " + stack.size());
        System.out.println("Popped element is : " + stack.pop());
        System.out.println("Top element is : " + stack.peek());
    }

}
