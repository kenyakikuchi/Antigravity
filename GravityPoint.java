import java.awt.Color;
import java.awt.Graphics;

// gravity point : oval
public class GravityPoint extends Circle {
    public double power;
    public double coreRadius;
    public Color coreColor;

    // constructor1
    GravityPoint() {
        super();
        init();
    }

    // constructor2
    GravityPoint(double[] coordinate) {
        super(coordinate);
        init();
    }

    // constructor3
    GravityPoint(double x, double y) {
        super(x, y);
        init();
    }

    public void init() {
        power = 1;
        coreRadius = 10;
        color = Colors.GREEN;
        coreColor = Colors.BLACK;
    }

    @Override
    public void show(Graphics g) {
        if (visible == false) {
            return;
        }

        super.show(g);

        // draw core
        g.setColor(coreColor);
        g.fillOval((int)coordinate[0] - (int)(coreRadius / 2), (int)coordinate[1] - (int)(coreRadius / 2), (int)coreRadius, (int)coreRadius);
    }

    public void setPower(double p) {
        power = p;
    }

    public void setCoreRadius(double r) {
        coreRadius = r;
    }
}