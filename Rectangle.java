import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangle extends MovableObject {
    // constant
    private static final int[] defaultSize = {100, 150};

    // variable
    protected int size[];

    // constructor1
    Rectangle() {
        super();
        size = new int[2];
        setSize(defaultSize);
        init();
    }

    // constructor2
    Rectangle(double[] coordinate) {
        super(coordinate);
        size = new int[2];
        setSize(defaultSize);
        init();
    }

    // constructor3
    Rectangle(double x, double y) {
        super(x, y);
        size = new int[2];
        setSize(defaultSize);
        init();
    }

    public void init() {
        setColor(Colors.BLUE);
    }

    @Override
    public void show(Graphics2D g2d) {
        if (visible == false) {
            return;
        }

        super.show(g2d);

        g2d.setColor(color);
        g2d.fillRect(
            (int)(coordinate[0] - size[0] / 2),
            (int)(coordinate[1] - size[1] / 2),
            (int)size[0], (int)size[1]
        );
    }

    // acccessor
    public void setSize(double[] s) {
        size[0] = (int)s[0];
        size[1] = (int)s[1];
    }

    public void setSize(int[] s) {
        size[0] = s[0];
        size[1] = s[1];
    }

    public void setSize(double width, double height) {
        size[0] = (int)width;
        size[1] = (int)height;
    }

    public void setSize(int width, int height) {
        size[0] = width;
        size[1] = height;
    }

    public int[] getSize() {
        return size;
    }
}