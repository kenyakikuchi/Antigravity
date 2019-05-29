import java.awt.Graphics;

// movable object
public class MovableObject {
    public static boolean visible = true;
    public double[] coordinate = {0, 0};
    public double[] velocity = {0, 0};

    public void move(int dt) {}
    public void show(Graphics g) {}
}