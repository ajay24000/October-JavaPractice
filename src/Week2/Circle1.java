package Week2;

public class Circle1 implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }

    public static void main(String[] args) {
        Circle1 obj = new Circle1();
        obj.draw();
    }
}
