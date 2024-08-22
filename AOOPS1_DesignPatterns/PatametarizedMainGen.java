class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

public class PatametarizedMainGen {
    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<>(3033, "Ravi");
        System.out.println("Initial Key and value:");
        System.out.println(p1.getValue());
        System.out.println(p1.getKey());
        p1.setValue("rose");
        p1.setKey(12);
        System.out.println("Modified Key and value:");
        System.out.println(p1.getValue());
        System.out.println(p1.getKey());
    }
}
