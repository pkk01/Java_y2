package Year2;

interface VideoPlayer {
    void player();
}

// adaptee
class ClassicPlayer {
    void classicPlayer() {
        System.out.println("Classic Player playing a Video");
    }
}

// Adapter

class PlayerAdapter implements VideoPlayer {
    ClassicPlayer cp = new ClassicPlayer();

    @Override
    public void player() {
        cp.classicPlayer();
    }
}

// client code
public class AdapterClient {
    public static void main(String[] args) {
        PlayerAdapter pa = new PlayerAdapter();
        pa.player();
    }
}