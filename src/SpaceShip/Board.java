/**
 * @author Daniele Bufalo
 * @version 1.0
 */
package SpaceShip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

// TODO: Auto-generated Javadoc
/**
 * The Class Board.
 */
public class Board extends JPanel implements ActionListener {

    /** The timer. */
    private Timer timer;
    
    /** The space ship. */
    private SpaceShip spaceShip;
    
    /** The delay. */
    private final int DELAY = 10;

    /**
     * Instantiates a new board.
     */
    public Board() {

        initBoard();
    }

    /**
     * Inits the board.
     */
    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.black);
        setDoubleBuffered(true);

        spaceShip = new SpaceShip();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    /**
     * Do drawing.
     *
     * @param g the g
     */
    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(spaceShip.getImage(), spaceShip.getX(), 
            spaceShip.getY(), this);
    }
    
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        step();
    }
    
    /**
     * Step.
     */
    private void step() {
        
        spaceShip.move();
        
        repaint(spaceShip.getX()-1, spaceShip.getY()-1, 
                spaceShip.getWidth()+2, spaceShip.getHeight()+2);     
    }    

    /**
     * The Class TAdapter.
     */
    private class TAdapter extends KeyAdapter {

        /* (non-Javadoc)
         * @see java.awt.event.KeyAdapter#keyReleased(java.awt.event.KeyEvent)
         */
        @Override
        public void keyReleased(KeyEvent e) {
            spaceShip.keyReleased(e);
        }

        /* (non-Javadoc)
         * @see java.awt.event.KeyAdapter#keyPressed(java.awt.event.KeyEvent)
         */
        @Override
        public void keyPressed(KeyEvent e) {
            spaceShip.keyPressed(e);
        }
    }
}