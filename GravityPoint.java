import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

// gravity point : oval
public class GravityPoint extends Circle {
    // constants
    private static final double defalutPower = 1;
    private static final int defalutCoreRadius = 20;
    private static final Color defalutCoreColor = Colors.BLACK;

    // variables
    protected double power;
    protected int coreRadius;
    protected Color coreColor;

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

    // constructor4
    GravityPoint(int x, int y) {
        super((double)x, (double)y);
        init();
    }

    public void init() {
        setColor(Colors.GREEN);
        setRadius(200);

        setPower(defalutPower);
        setCoreRadius(defalutCoreRadius);
        setCoreColor(defalutCoreColor);
    }

    @Override
    public void show(Graphics2D g2d) {
        if (visible == false) {
            return;
        }

        super.show(g2d);

        // draw core
        g2d.setColor(coreColor);
        g2d.fillOval((int)coordinate[0] - (int)(coreRadius / 2), (int)coordinate[1] - (int)(coreRadius / 2), coreRadius, coreRadius);
    }

    // acccessor
    public void setPower(double p) {
        power = p;
    }

    public double getPower() {
        return power;
    }

    public void setCoreRadius(int r) {
        coreRadius = r;
    }

    public int getCoreRadius() {
        return coreRadius;
    }

    public void setCoreColor(Color c) {
        coreColor = c;
    }

    public Color getCoreColor() {
        return coreColor;
    }
}