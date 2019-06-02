import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;

// car
public class Car extends MovableObject {
    public int radius = 30;

    // constructor1
    Car() {
        super();
    }

    // constructor2
    Car(double[] coordinate) {
        super();
        setLocation(coordinate[0], coordinate[1]);
    }

    // constructor3
    Car(double x, double y) {
        super();
        setLocation(x, y);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval((int)super.coordinate[0] - (radius / 2), (int)super.coordinate[1] - (radius / 2), radius, radius);
    }

    public void setRadius(int r) {
        radius = r;
    }
}