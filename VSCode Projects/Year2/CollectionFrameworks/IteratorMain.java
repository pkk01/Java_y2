

import java.util.ArrayList;
import java.util.List;

interface Iterator<T> {
    boolean hasNext();

    T next();
}

// Iterable collection interface
interface IterableCollection<T> {
    Iterator<T> createIterator();
}

// concrete Collection class
class MyCollection<T> implements IterableCollection<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public Iterator<T> createIterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int index = 0;

        public boolean hasNext() {
            return index < items.size();
        }

        public T next() {
            return items.get(index++);
        }
    }
}

public class IteratorMain {
    public static void main(String[] args) {
        MyCollection<String> collection = new MyCollection();
        collection.add("Item 1");
        collection.add("Item 2");
        collection.add("Item 3");
        collection.add("Item 4");
        Iterator<String> iterator = collection.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
