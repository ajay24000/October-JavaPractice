package Week2;

import java.lang.Math;

class Shape8 {
    double radius;
    double length;
    double breadth;
}
public abstract class Shape7 {
    public abstract void calculatePerimeter1(Shape8 obj);

    public abstract void calculateArea1(Shape8 obj);

}
class Circle2 extends Shape7 {
    @Override
    public void calculateArea1(Shape8 obj) {
        double area  = Math.PI * obj.radius * obj.radius;
        System.out.println("Area of Circle: "+area);
    }
    @Override
    public void calculatePerimeter1(Shape8 obj) {
        double perimeter = 2 * Math.PI * obj.radius;
        System.out.println("Perimeter of Circle: "+perimeter);
    }
}

class Rectangle2 extends Shape7 {
    @Override
    public void calculateArea1(Shape8 obj) {

        double area1 = obj.length * obj.breadth ;
        System.out.println(area1);
    }
    @Override
    public void calculatePerimeter1(Shape8 obj) {
        double perimeter1 = 2 * (obj.length + obj.breadth);
        System.out.println(perimeter1);
    }

}
class Main1 {
    public static void main(String[] args) {
        Shape8 obj3 = new Shape8();
        Shape8 obj4 = new Shape8();
        obj3.radius = 5;
        obj4.breadth = 6;
        obj4.length = 4;

        Circle2 circle = new Circle2();
        circle.calculateArea1(obj3);
        circle.calculatePerimeter1(obj3);
        Rectangle2 rectangle = new Rectangle2();
        rectangle.calculateArea1(obj4);
        rectangle.calculatePerimeter1(obj4);
    }
}
