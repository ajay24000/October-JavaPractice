package Week2;

class Shape {
    private final String shapeName;
    private final String shapeColor;

    public Shape(String name,String color) {
        this.shapeName = name;
        this.shapeColor = color;
    }
    public void display() {
        System.out.println("ShapeName: "+ shapeName+ "\nShapeColor: " +shapeColor);
    }

}
public class Challenge2 {
    public static void main(String[] args) {
        Shape obj1 = new Shape("Circle","Red");
        Shape obj2 = new Shape("Rectangle","Blue");
        obj1.display();
        obj2.display();
    }

}
