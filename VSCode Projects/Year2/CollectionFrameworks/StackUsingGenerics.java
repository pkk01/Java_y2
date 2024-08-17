public class StackUsingGenerics<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;

    public StackUsingGenerics() {
        top = null;
    }

    public void push(T item) {

    }
}
