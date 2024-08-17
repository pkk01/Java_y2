interface Shape {
    void draw();
}

// concrete classes to implement shape
class Rectangle implements Shape {
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Shape: Circle");
    }
}

// abstract decorator class implementing the Shape interface
abstract class ShapeDecorator implements Shape {
    protected Shape shape;

    ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    public void draw() {
        shape.draw();
    }
}

// Create concrete decorator classes extending the ShapeDecorator class
class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    public void draw() {
        shape.draw();
        setRedBorder(shape);
    }

    private void setRedBorder(Shape shape) {
        System.out.println("Border color: Red");
    }
}

public class DecoratorMainShape {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        Shape redcircle = new RedShapeDecorator(new Circle());
        Shape redrectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Normal circle: ");
        circle.draw();
        System.out.println("Normal Rectangle");
        rectangle.draw();
        System.out.println("circle with red border: ");
        redcircle.draw();
        System.out.println("Rectangle with red Border: ");
        redrectangle.draw();

    }
}
