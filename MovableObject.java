import java.awt.Color;
import java.awt.Graphics;

// movable object
public class MovableObject {
    public boolean visible;
    public double[] coordinate;
    public double[] velocity;
    public Color color;

    MovableObject() {
        super();
        visible = true;
        coordinate = new double[2];
        velocity = new double[2];
        color = Colors.BLACK;
    }

    public void setLocation(double x, double y) {
        coordinate[0] = x;
        coordinate[1] = y;
    }

    public void setVelocity(double vx, double vy) {
        velocity[0] = vx;
        velocity[1] = vy;
    }

    public void setColor(Color c) {
        color = c;
    }

    public void setVisible(boolean flag) {
        visible = flag;
    }

    public void move(int dt) {
        coordinate[0] += dt * velocity[0];
        coordinate[1] += dt * velocity[1];
    }

    public void show(Graphics g) {
        if (visible == false) {
            return;
        }

        g.setColor(color);
    }
}