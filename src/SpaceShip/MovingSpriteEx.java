/**
 * @author Daniele Bufalo
 * @version 1.0
 */
package SpaceShip;

import java.awt.EventQueue;
import javax.swing.JFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class MovingSpriteEx.
 */
public class MovingSpriteEx extends JFrame {

    /**
     * Instantiates a new moving sprite ex.
     */
    public MovingSpriteEx() {

        initUI();
    }

    /**
     * Inits the UI.
     */
    private void initUI() {

        add(new Board());

        setTitle("Moving sprite");
        setSize(400, 300);

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            MovingSpriteEx ex = new MovingSpriteEx();
            ex.setVisible(true);
        });
    }
}