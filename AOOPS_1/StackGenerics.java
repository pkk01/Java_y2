import java.util.EmptyStackException;

public class StackGenerics<T> {
    private Node<T> top;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public StackGenerics() {
        top = null;
    }

    public void push(T item) {
        Node<T> node = new Node<>(item);
        node.next = top;
        top = node;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printStack() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node temp = top;
        while (temp.next != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        StackGenerics<String> st = new StackGenerics<>();
        st.push("Name1");
        st.push("Name2");
        st.push("Name3");
        st.push("Name4");
        st.push("Name5");
        System.err.println("All elements: ");
        st.printStack();
        System.out.println("Element on the top: " + st.peek());
        System.out.println("Element popped: " + st.pop());
        System.out.println("Element on top: " + st.peek());

    }
}
