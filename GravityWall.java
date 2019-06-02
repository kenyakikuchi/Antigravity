import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

// gravity wall : rectangle
public class GravityWall extends Rectangle {
    // constants
    private static final double defalutPower = 1;
    private static final double defalutHitDistance = 200;

    // variables
    protected double power;
    protected double hitDistance;
    protected Color hitColor;

    // constructor1
    GravityWall() {
        super();
        init();
    }

    // constructor2
    GravityWall(double[] coordinate) {
        super(coordinate);
        init();
    }

    // constructor3
    GravityWall(double x, double y) {
        super(x, y);
        init();
    }

    // constructor4
    GravityWall(int x, int y) {
        super((double)x, (double)y);
        init();
    }

    public void init() {
        power = defalutPower;
        hitDistance = defalutHitDistance;
        setHitColor(Colors.YELLOW);
    }

    @Override
    public void show(Graphics2D g2d) {
        if (visible == false) {
            return;
        }

        g2d.setColor(hitColor);
        g2d.fillRect(
            (int)(coordinate[0] - (size[0] + hitDistance) / 2),
            (int)(coordinate[1] - (size[1] + hitDistance) / 2),
            (int)(size[0] + hitDistance), (int)(size[1] + hitDistance)
        );

        super.show(g2d);
    }

    // acccessor
    public void setPower(double p) {
        power = p;
    }

    public double getPower() {
        return power;
    }

    public void setHitDistance(double d) {
        hitDistance = d;
    }

    public double getHitDistance() {
        return hitDistance;
    }

    public void setHitColor(Color c) {
        hitColor = c;
    }

    public Color getHitColor() {
        return hitColor;
    }
}