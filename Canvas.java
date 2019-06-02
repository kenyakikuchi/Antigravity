import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

class Canvas extends JPanel {
    protected static Car car;
    protected static GravityPoint gp;
    protected static GravityWall gw;
    protected static MouseEvent mouse;

    Canvas() {
        super();

        car = new Car(100, 200);
        gp = new GravityPoint(50, 50);
        gw = new GravityWall(320, 240);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        update();
        display(g2d);
    }

    // update all objects
    public void update() {
    }

    // show all objects
    public void display(Graphics2D g2d) {
        gp.show(g2d);
        gw.show(g2d);
        car.show(g2d);
    }

    public void setMouseEvent(MouseEvent event) {
        mouse = event;
    }
}