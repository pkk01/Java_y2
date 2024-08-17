interface Player {
    void play();
}

class Cricket implements Player {
    @Override
    public void play() {
        System.out.println("Cricket Player");
    }
}

public class PlayerDemo {
    public static void main(String[] args) {
        Cricket c = new Cricket();
        c.play();
    }
}
