import java.awt.Graphics;

// car
public class Car extends Circle {
    // constructor1
    Car() {
        super();
    }

    // constructor2
    Car(double[] coordinate) {
        super(coordinate);
    }

    // constructor3
    Car(double x, double y) {
        super(x, y);
    }

    @Override
    public void show(Graphics g) {
        if (visible == false) {
            return;
        }

        super.show(g);
    }
}