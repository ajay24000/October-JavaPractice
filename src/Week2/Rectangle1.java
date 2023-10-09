package Week2;

public class Rectangle1 implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }

    public static void main(String[] args) {
        Rectangle1 obj = new Rectangle1();
        obj.draw();
    }
}
