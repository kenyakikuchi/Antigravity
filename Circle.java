import java.awt.Graphics;

// circle object
public class Circle extends MovableObject {
    public int radius = 30;

    // constructor1
    Circle() {
        super();
    }

    // constructor2
    Circle(double[] coordinate) {
        super();
        setLocation(coordinate[0], coordinate[1]);
    }

    // constructor3
    Circle(double x, double y) {
        super();
        setLocation(x, y);
    }

    @Override
    public void show(Graphics g) {
        if (visible == false) {
            return;
        }

        super.show(g);

        g.fillOval((int)coordinate[0] - (radius / 2), (int)coordinate[1] - (radius / 2), radius, radius);
    }

    public void setRadius(int r) {
        radius = r;
    }
}