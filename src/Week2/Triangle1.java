package Week2;

public class Triangle1 implements Drawable{
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle");
    }

    public static void main(String[] args) {
        Triangle1 obj = new Triangle1();
        obj.draw();
    }
}
