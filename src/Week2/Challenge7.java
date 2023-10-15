package Week2;

import java.lang.Math;

abstract class Challenge7 {
    public abstract void calculatePerimeter1();

    public abstract void calculateArea1();

}
class Circle2 extends Challenge7 {

    private double radius;
    Circle2(double radius) {
        this.radius = radius;
    }
    public void calculateArea1() {
        double area  = Math.PI * radius * radius;
        System.out.println("Area of Circle is: "+area);
    }

    public void calculatePerimeter1() {
        double perimeter = 2 * Math.PI * radius;
        System.out.println("Perimeter of Circle is: "+perimeter);
    }
}

class Rectangle2 extends Challenge7 {

    private double length;
    private double breadth;
    Rectangle2 (double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void calculateArea1() {

        double area1 = length * breadth ;
        System.out.println("Area of Rectangle is: "+area1);
    }

    public void calculatePerimeter1() {
        double perimeter1 = 2 * (length + breadth);
        System.out.println("Perimeter of Rectangle is: "+perimeter1);
    }

}
class Main1 {
    public static void main(String[] args) {

        Challenge7 circle = new Circle2(5);
        circle.calculateArea1();
        circle.calculatePerimeter1();
        Challenge7 rectangle = new Rectangle2(4,6);
        rectangle.calculateArea1();
        rectangle.calculatePerimeter1();
    }
}
