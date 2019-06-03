import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.lang.Math;

// car
public class Car extends Circle {
    // variable
    protected double[] destination;
    protected boolean destFlag;

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
        destination = new double[2];
        destFlag = false;
    }

    double getDistance(double[] p1, double[] p2) {
        double diffX = p1[0] - p2[0];
        double diffY = p1[1] - p2[1];
        return Math.sqrt(diffX * diffX + diffY * diffY);
    }

    double getAngleRad(double[] p1, double[] p2) {
        double diffX = p1[0] - p2[0];
        double diffY = p1[1] - p2[1];
        return Math.atan2(diffY, diffX);
    }

    // calculate velocity to move to destination
    public void moveToDestination(){
        // move to destination
        double distance = getDistance(destination, coordinate);
        double speed = (distance < MAX_SPEED)? distance : MAX_SPEED;
        double theta = getAngleRad(destination, coordinate);

        setVelocity(speed * Math.cos(theta), speed * Math.sin(theta));

        if (distance < 1) {
            setDestFlag(false);
            setVelocity(0, 0);
        }
    }

    // calculate repulsion from GravityPoint ***high quality***
    public void calcGravityPoint(GravityPoint gp) {
        double distance = getDistance(gp.getLocation(), coordinate) - (getRadius() / 2);

        // when the car close to the GravityPoint
        if (distance < gp.getRadius() / 2) {
            double theta = getAngleRad(gp.getLocation(), coordinate);
            double coefficient = Math.pow(distance / (gp.getRadius() / 2), -2);
            double x = gp.getPower() * Math.cos(theta) * coefficient;
            double y = gp.getPower() * Math.sin(theta) * coefficient;
            setVelocity(getVelocity()[0] - x, getVelocity()[1] - y);
        }
    }

    // calculate repulsion from GravityWall ***low quality***
    public void calcGravityWall(GravityWall gw) {
        double dx = gw.getLocation()[0] - coordinate[0] - getRadius() / 2;
        double dy = gw.getLocation()[1] - coordinate[1] - getRadius() / 2;
        double dx_plus = dx + gw.getSize()[0] / 2;
        double dy_plus = dy + gw.getSize()[1] / 2;
        double dx_minus = dx - gw.getSize()[0] / 2;
        double dy_minus = dy - gw.getSize()[1] / 2;
        double boundX = (gw.getSize()[0] + gw.getHitDistance()) / 2;
        double boundY = (gw.getSize()[1] + gw.getHitDistance()) / 2;
        double theta = getAngleRad(gw.getLocation(), coordinate);
        double x = 0;
        double y = 0;

        // when the car close to the GravityWall
        if (Math.abs(dx) - radius / 2 < boundX && Math.abs(dy) - radius / 2 < boundY) {
            // left side
            if (coordinate[0] < gw.getLocation()[0] - gw.getSize()[0] / 2) {
                if (coordinate[1] < gw.getLocation()[1] - gw.getSize()[1] / 2) {
                    // left upper
                    double distance = Math.sqrt(dx_minus * dx_minus + dy_minus * dy_minus);
                    double coefficient = Math.pow(distance / (gw.getHitDistance() / 2), -2);
                    x = -1 * gw.getPower() * Math.cos(theta) * coefficient;
                    y = -1 * gw.getPower() * Math.sin(theta) * coefficient;
                } else if (coordinate[1] > gw.getLocation()[1] + gw.getSize()[1] / 2) {
                    // left bottom
                    double distance = Math.sqrt(dx_minus * dx_minus + dy_plus * dy_plus);
                    double coefficient = Math.pow(distance / (gw.getHitDistance() / 2), -2);
                    x = -1 * gw.getPower() * Math.cos(theta) * coefficient;
                    y = -1 * gw.getPower() * Math.sin(theta) * coefficient;
                } else {
                    // left middle
                    double coefficient = Math.pow(dx_minus / (gw.getHitDistance() / 2), -2);
                    x = -1 * gw.getPower() * Math.cos(theta) * coefficient;
                }
            }

            // right side
            else if (coordinate[0] > gw.getLocation()[0] + gw.getSize()[0] / 2) {
                if (coordinate[1] < gw.getLocation()[1] - gw.getSize()[1] / 2) {
                    // right upper
                    double distance = Math.sqrt(dx_plus * dx_plus + dy_minus * dy_minus);
                    double coefficient = Math.pow(distance / (gw.getHitDistance() / 2), -2);
                    x = -1 * gw.getPower() * Math.cos(theta) * coefficient;
                    y = -1 * gw.getPower() * Math.sin(theta) * coefficient;
                } else if (coordinate[1] > gw.getLocation()[1] + gw.getSize()[1] / 2) {
                    // right bottom
                    double distance = Math.sqrt(dx_plus * dx_plus + dy_plus * dy_plus);
                    double coefficient = Math.pow(distance / (gw.getHitDistance() / 2), -2);
                    x = -1 * gw.getPower() * Math.cos(theta) * coefficient;
                    y = -1 * gw.getPower() * Math.sin(theta) * coefficient;
                } else {
                    // right middle
                    double coefficient = Math.pow(dx_plus / (gw.getHitDistance() / 2), -2);
                    x = -1 * gw.getPower() * Math.cos(theta) * coefficient;
                }
            }

            // center side
            else {
                if (coordinate[1] < gw.getLocation()[1] - gw.getSize()[1] / 2) {
                    // center upper
                    double coefficient = Math.pow(dy_minus / (gw.getHitDistance() / 2), -2);
                    y = -1 * gw.getPower() * Math.sin(theta) * coefficient;
                } else if (coordinate[1] > gw.getLocation()[1] + gw.getSize()[1] / 2) {
                    // center bottom
                    double coefficient = Math.pow(dy_plus / (gw.getHitDistance() / 2), -2);
                    y = -1 * gw.getPower() * Math.sin(theta) * coefficient;
                }
            }
        }

        setVelocity(getVelocity()[0] + x, getVelocity()[1] + y);
    }

    // acccessor
    public void setDestination(double[] d) {
        destination[0] = d[0];
        destination[1] = d[1];
    }

    public void setDestination(int[] d) {
        destination[0] = d[0];
        destination[1] = d[1];
    }

    public void setDestination(double x, double y) {
        destination[0] = x;
        destination[1] = y;
    }

    public void setDestination(int x, int y) {
        destination[0] = x;
        destination[1] = y;
    }

    public double[] getDestination() {
        return destination;
    }

    public void setDestFlag(boolean f) {
        destFlag = f;
    }

    public boolean getDestFlag() {
        return destFlag;
    }
}
