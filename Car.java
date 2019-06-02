import java.awt.Graphics;
import java.awt.Graphics2D;

// car
public class Car extends Circle {
    // constructor1
    Car() {
        super();
        init();
    }

    // constructor2
    Car(double[] coordinate) {
        super(coordinate);
        init();
    }

    // constructor3
    Car(double x, double y) {
        super(x, y);
        init();
    }

    // constructor4
    Car(int x, int y) {
        super((double)x, (double)y);
        init();
    }

    public void init() {
        setColor(Colors.RED);
    }

    @Override
    public void show(Graphics2D g2d) {
        if (visible == false) {
            return;
        }

        super.show(g2d);
    }
}