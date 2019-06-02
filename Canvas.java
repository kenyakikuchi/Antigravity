import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

class Canvas extends JPanel {
    static Car car;
    static GravityPoint gp;
    static GravityWall gw;
    static MouseEvent mouse;

    Canvas() {
        super();

        car = new Car(100, 200);
        gp = new GravityPoint(50, 50);
        gw = new GravityWall(320, 240);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        gp.show(g2d);
        gw.show(g2d);
        car.show(g2d);
    }

    public void setMouseEvent(MouseEvent event) {
        mouse = event;
    }

    public void update() {
    }
}