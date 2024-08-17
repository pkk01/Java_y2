interface Iterator {
    boolean hasNext();

    Object next();
}

class SalaryIterator implements Iterator {
    double salaries[] = { 20000, 22000, 23000, 24000, 29000};
    int index = 0;

    public boolean hasNext() {
        if (index < salaries.length) {
            return true;
        }
        return false;
    }

    public Object next() {
        if (hasNext())
            return salaries[index++];
        return null;
    }
}

public class IteratorMain {
    public static void main(String[] args) {
        SalaryIterator si = new SalaryIterator();
        while (si.hasNext()) {
            double sal = (double) si.next();
            System.out.println("Salary: " + sal);
        }
    }
}
