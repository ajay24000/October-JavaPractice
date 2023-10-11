package Week2;

interface Drawable {
    void draw();
}

class Circle1 implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Triangle1 implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle");
    }
}

class Rectangle1 implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}
public class Challenge4 {

    public static void main(String[] args) {

        Circle1 circle = new Circle1();
        circle.draw();

        Rectangle1 rectangle = new Rectangle1();
        rectangle.draw();

        Triangle1 triangle = new Triangle1();
        triangle.draw();
    }
}
