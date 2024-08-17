class Pair<Key, Value> {
    private Key key;
    private Value value;

    public Pair(Key key, Value value) {
        // setters
        this.key = key;
        this.value = value;
    }

    // Setters
    public void setKey(Key key) {
        this.key = key;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    // Getters
    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }

}

public class ParameterizedGenerics {
    public static void main(String[] args) {
        Pair<Integer, String> p0 = new Pair<>(1001, "Employee1");
        Pair<Integer, String> p1 = new Pair<>(1002, "Employee2");
        p0.setKey(1003);
        p0.setValue("Sita");
        System.out.println("Key and Value for p0: " + p0.getKey() + " and " + p0.getValue());
        System.out.println("Key and Value for p1: " + p1.getKey() + " and " + p1.getValue());

    }
}
