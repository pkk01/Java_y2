interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("I am a circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("I am Square");
    }
}

class FillBlue implements Shape {
    Shape sh;

    FillBlue(Shape sh1) {
        sh = sh1;
    }

    public void draw() {
        sh.draw();
        System.out.println("Object is filled with blue color");
    }
}

class BorderRed implements Shape {
    Shape sh;

    BorderRed(Shape sh1) {
        sh = sh1;
    }

    public void draw() {
        sh.draw();
        System.out.println("Object is filled with red border");
    }
}

public class SimpleDecorator {
    public static void main(String[] args) {
        Shape sh;
        sh = new Square();
        sh = new BorderRed(new FillBlue(sh));
        // sh = new FillBlue(sh);
        sh.draw();
    }
}