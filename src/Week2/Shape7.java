package Week2;

import java.lang.Math;

public abstract class Shape7 {
    public abstract void calculatePerimeter1(double radius,double length,double breadth);

    public abstract void calculateArea1(double radius,double length,double breadth);

}
class Circle2 extends Shape7 {
    @Override
    public void calculateArea1(double radius,double length,double breadth) {
        double area  = Math.PI * radius * radius;
        System.out.println("Area of Circle: "+area);
    }
    @Override
    public void calculatePerimeter1(double radius,double length,double breadth) {
        double perimeter = 2 * Math.PI * radius;
        System.out.println("Perimeter of Circle: "+perimeter);
    }
}

class Rectangle2 extends Shape7 {
    @Override
    public void calculateArea1(double radius, double length , double breadth) {
        double area1 = length * breadth ;
        System.out.println(area1);
    }
    @Override
    public void calculatePerimeter1(double radius,double length , double breadth) {
        double perimeter1 = 2 * (length + breadth);
        System.out.println(perimeter1);
    }

}
class Main1 {
    public static void main(String[] args) {
        Circle2 circle = new Circle2();
        circle.calculateArea1(5.0,0,0);
        circle.calculatePerimeter1(5,0,0);
        Rectangle2 rectangle = new Rectangle2();
        rectangle.calculateArea1(0,4,6);
        rectangle.calculatePerimeter1(0,4,6);
    }
}
