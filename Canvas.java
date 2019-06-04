import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.GraphicsEnvironment;

class Canvas extends JPanel {
    // variables
    protected static Car car;
    protected static GravityPoint[] gps;
    protected static GravityWall[] gws;
    protected static MouseEvent mouse;
    protected static boolean isClicked = false;
    static int WIDTH = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
    static int HEIGHT = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();

    Canvas() {
        super();

        car = new Car(100, 200);
        car.setRadius(100);

        gps = new GravityPoint[15];
        int[][] pos = {
            {2, 1},
            {4, 1},
            {6, 1},
            {8, 1},
            {10, 1},
            {1, 3},
            {3, 3},
            {5, 3},
            {7, 3},
            {9, 3},
            {2, 5},
            {4, 5},
            {6, 5},
            {8, 5},
            {10, 5}
        };
        for (int i = 0; i < pos.length; i++) {
            gps[i] = new GravityPoint(WIDTH * pos[i][0] / 11, HEIGHT * pos[i][1] / 6);
            gps[i].setRadius(300);
        }
        gws = new GravityWall[1];
        /*gws[0] = new GravityWall(100, 120);
        gws[1] = new GravityWall(540, 120);
        gws[2] = new GravityWall(980, 120);
        gws[3] = new GravityWall(320, 330);
        gws[4] = new GravityWall(760, 330);
        gws[5] = new GravityWall(1200, 330);*/
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        display(g2d);
    }

    // update all objects
    public void update(int timer_count) {
        // something related to mouse event
        if (mouse != null) {
            if (mouse.getButton() == MouseEvent.BUTTON1) {
                // when the left mouse button was clicked
                if (isClicked == false) {
                    isClicked = true;
                    car.setDestination(mouse.getX(), mouse.getY());
                    car.setDestFlag(true);
                }
            } else {
                // when the left mouse button was released
                if (isClicked == true) {
                    isClicked = false;
                }
            }
        }

        if (car.getDestFlag() == true) {
            // calculate velocity to move to destination
            car.moveToDestination();

            // calculate repulsion from GrabityWall
            if (gws != null) {
                for (int i = 0; i < gws.length; i++) {
                    if (gws[i] != null) {
                        car.calcGravityWall(gws[i]);
                    }
                }
            }

            // calculate repulsion from GravityPoint
            if (gps != null) {
                for (int i = 0; i < gps.length; i++) {
                    if (gps[i] != null) {
                        car.calcGravityPoint(gps[i]);
                    }
                }
            }

            // move car by calculated velocity
            car.move(timer_count);
        }
    }

    // show all objects
    public void display(Graphics2D g2d) {
        // reflesh display
        g2d.setColor(Colors.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // show all objects
        if (gws != null) {
            for (int i = 0; i < gws.length; i++) {
                if (gws[i] != null) {
                    gws[i].show(g2d);
                }
            }
        }
        if (gps != null) {
            for (int i = 0; i < gps.length; i++) {
                if (gps[i] != null) {
                    gps[i].show(g2d);
                }
            }
        }
        car.show(g2d);
    }

    public void setMouseEvent(MouseEvent event) {
        mouse = event;
    }
}
