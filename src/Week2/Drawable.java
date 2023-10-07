package Week2;

public interface Drawable {
    void draw();
}

class Circle1 implements Drawable {

    public void draw() {
        System.out.println("Drawing a circle");
    }
}
class Rectangle1 implements Drawable {

    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}
class Triangle1 implements Drawable {

    public void draw() {
        System.out.println("Drawing a Triangle");
    }
}
class Main {
    public static void main(String[] args) {
        Circle1 circle = new Circle1();
        Rectangle1 rectangle = new Rectangle1();
        Triangle1 triangle = new Triangle1();

        circle.draw();
        rectangle.draw();
        triangle.draw();
    }
}
