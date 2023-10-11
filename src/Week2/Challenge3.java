package Week2;

class ShapeClass {

    public double area() {
        return 0;
    }

    public double perimeter() {
        return 0;
    }

}
class Circle extends ShapeClass {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
class Rectangle extends ShapeClass{
    private double length;
    private double width;

    public Rectangle(double length,double width) {
        this.length = length;
        this.width = width;
    }
    @Override
    public double area() {
        return length * width;
    }
    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}
class Triangle extends ShapeClass{
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    @Override
    public double area() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }
}
public class Challenge3 {

    public static void main(String[] args) {
        ShapeClass circle = new Circle(5.0);
        System.out.println("Circle Area: " + circle.area());
        System.out.println("Circle Perimeter: " + circle.perimeter());

        ShapeClass rectangle = new Rectangle(4.0, 6.0);
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Rectangle Perimeter: " + rectangle.perimeter());

        ShapeClass triangle = new Triangle(3.0, 4.0, 5.0);
        System.out.println("Triangle Area: " + triangle.area());
        System.out.println("Triangle Perimeter: " + triangle.perimeter());
    }

}
