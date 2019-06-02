import java.awt.Graphics;
import java.awt.Graphics2D;

// circle object
public class Circle extends MovableObject {
    // constant
    private static final int defalutRadius = 30;

    // variable
    protected int radius;

    // constructor1
    Circle() {
        super();
        radius = defalutRadius;
        init();
    }

    // constructor2
    Circle(double[] coordinate) {
        super(coordinate);
        radius = defalutRadius;
        init();
    }

    // constructor3
    Circle(double x, double y) {
        super(x, y);
        radius = defalutRadius;
        init();
    }

    public void init() {
    }

    @Override
    public void show(Graphics2D g2d) {
        if (visible == false) {
            return;
        }

        super.show(g2d);

        g2d.fillOval((int)coordinate[0] - (radius / 2), (int)coordinate[1] - (radius / 2), radius, radius);
    }

    // acccessor
    public void setRadius(int r) {
        radius = r;
    }

    public int getRadius() {
        return radius;
    }
}