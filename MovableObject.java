import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.Math;

// movable object
public class MovableObject {
    protected boolean visible;
    protected double[] coordinate;
    protected double[] velocity;
    protected Color color;
    protected double theta_rad;
    protected double theta_deg;

    // constructor1
    MovableObject() {
        visible = true;
        coordinate = new double[2];
        velocity = new double[2];
        color = Colors.BLACK;
        theta_deg = 0;
        theta_rad = 0;
    }

    // constructor2
    MovableObject(double[] coordinate) {
        visible = true;
        coordinate = new double[2];
        velocity = new double[2];
        color = Colors.BLACK;
        theta_deg = 0;
        theta_rad = 0;

        setLocation(coordinate[0], coordinate[1]);
    }

    // constructor3
    MovableObject(double x, double y) {
        visible = true;
        coordinate = new double[2];
        velocity = new double[2];
        color = Colors.BLACK;
        theta_deg = 0;
        theta_rad = 0;

        setLocation(x, y);
    }

    public void move(int dt) {
        coordinate[0] += dt * velocity[0];
        coordinate[1] += dt * velocity[1];
    }

    public void show(Graphics2D g2d) {
        if (visible == false) {
            return;
        }

        g2d.setColor(color);
    }

    // acccessor
    public void setVisible(boolean flag) {
        visible = flag;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setLocation(double x, double y) {
        coordinate[0] = x;
        coordinate[1] = y;
    }

    public double[] getLocation() {
        return coordinate;
    }

    public void setVelocity(double vx, double vy) {
        velocity[0] = vx;
        velocity[1] = vy;
    }

    public double[] getVelocity() {
        return velocity;
    }

    public void setColor(Color c) {
        color = c;
    }

    public Color getColor() {
        return color;
    }

    public void setThetaRad(double rad) {
        theta_rad = rad;
        theta_deg = Math.toDegrees(rad);
    }

    public double getThetaRad() {
        return theta_rad;
    }

    public void setThetaDeg(double deg) {
        theta_deg = deg;
        theta_rad = Math.toRadians(deg);
    }

    public double getThetaDeg() {
        return theta_deg;
    }
}