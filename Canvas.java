import javax.swing.JPanel;
import java.awt.Graphics;

class Canvas extends JPanel {
    static Car car;
    static GravityPoint gp;

    Canvas() {
        super();

        car = new Car(100, 100);
        car.setColor(Colors.RED);

        gp = new GravityPoint(50, 50);
        gp.setRadius(200);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        gp.show(g);
        car.show(g);
    }
}