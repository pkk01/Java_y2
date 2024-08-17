package Year2;

// Templete design pattern

abstract class Game {
    abstract void initalize();
    abstract void start();
    abstract void end();
    public final void play() {
        initalize();
        start();
        end();
    }
}

class Cricket extends Game {
    @Override
    void initalize() {
        System.out.println("Cricket game initialized");
    }
    @Override
    void start() {
        System.out.println("Cricket game started");
    }
    @Override
    void end() {
        System.out.println("Cricket game ends");
    }
}

class Football extends Game {
    @Override
    void initalize() {
        System.out.println("Football game initialized");
    }
    @Override
    void start() {
        System.out.println("Football game started");
    }
    @Override
    void end() {
        System.out.println("Football game ends");
    }
}

public class TemplateMain {
    public static void main(String[] args) {
        Game football = new Football();
        football.play();
        Game cricket = new Cricket();
        cricket.play();
    }
}
