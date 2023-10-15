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

        Drawable circle = new Circle1();
        circle.draw();

        Drawable rectangle = new Rectangle1();
        rectangle.draw();

        Drawable triangle = new Triangle1();
        triangle.draw();
    }
}
