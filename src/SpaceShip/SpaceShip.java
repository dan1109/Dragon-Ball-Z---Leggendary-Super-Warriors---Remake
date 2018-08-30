/**
 * @author Daniele Bufalo
 * @version 1.0
 */
package SpaceShip;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class SpaceShip.
 */
public class SpaceShip {

    /** The dx. */
    private int dx;
    
    /** The dy. */
    private int dy;
    
    /** The x. */
    private int x = 40;
    
    /** The y. */
    private int y = 60;
    
    /** The w. */
    private int w;
    
    /** The h. */
    private int h;
    
    /** The image. */
    private Image image;

    /**
     * Instantiates a new space ship.
     */
    public SpaceShip() {

        loadImage();
    }

    /**
     * Load image.
     */
    private void loadImage() {

        ImageIcon ii = new ImageIcon("resources\\images\\Icons\\select.png");
        image = ii.getImage();

        w = image.getWidth(null);
        h = image.getHeight(null);
    }

    /**
     * Move.
     */
    public void move() {

        x += dx;
        y += dy;
    }

    /**
     * Gets the x.
     *
     * @return the x
     */
    public int getX() {

        return x;
    }

    /**
     * Gets the y.
     *
     * @return the y
     */
    public int getY() {

        return y;
    }

    /**
     * Gets the width.
     *
     * @return the width
     */
    public int getWidth() {

        return w;
    }

    /**
     * Gets the height.
     *
     * @return the height
     */
    public int getHeight() {

        return h;
    }

    /**
     * Gets the image.
     *
     * @return the image
     */
    public Image getImage() {

        return image;
    }

    /**
     * Key pressed.
     *
     * @param e the e
     */
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }
    }

    /**
     * Key released.
     *
     * @param e the e
     */
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}