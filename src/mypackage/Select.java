/**
 * @author Daniele Bufalo
 * @version 1.0
 */
package mypackage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import mypackage.Resources;	//i renamed default package in mypackage cause it's better for import!!!

// TODO: Auto-generated Javadoc
/**
 * Work perfectly!.
 */
public class Select extends JPanel {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The b width. */
	private final int B_WIDTH = 500;

    /** The b height. */
    private final int B_HEIGHT = 450;

    /** The initial x. */
    //There are important! INITIAL X and Y!!
    public final int INITIAL_X = 125;//-40

    /** The initial y. */
    public final static int INITIAL_Y = 301;//-40

    /** The y height. */
    public final static int Y_HEIGHT = 381;//-40

    /**  x y for background. */
    private final int X = 0;//-40

    /** The y. */
    private final int Y = 0;//-40

    /** The options. */
    public Image options;

    /** The select. */
    public Image select;

    /** The y. */
    private int x;

	public static int y;

    /**
     * Instantiates a new select.
     */
    public Select()
    {
    	//initBoard();
    }
    /**
     * Load image.
     */
    private void loadSelect() {

        ImageIcon ii = new ImageIcon(Resources.getBasePath()+Resources.getIconsPath()+"select.png");
        select = ii.getImage();
    }

    /**
     * Inits the board.
     */
    public void initBoard() {

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setDoubleBuffered(true);

        loadOptions();
        loadSelect();

        x = INITIAL_X;
        y = INITIAL_Y;
    }


    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawOptions(g);
        drawSelect(g);
    }

    /**
 	 * Select up.
 	 */
 	public void selectUp()
	    {
 		Select.y-=25;
				if(Select.y<=Select.INITIAL_Y)
				{
					Select.y=Select.INITIAL_Y;
				}
				repaint();
	    }

    	/**
    	 * Select down.
    	 */
    	public void selectDown()
	    {
	    		Select.y+=25;
		        if (Select.y > Select.Y_HEIGHT) {
		        	Select.y = Select.INITIAL_Y;
		        }
		        repaint();
	    }


    /**
     * Draw select.
     *
     * @param g the g
     */
    private void drawSelect(Graphics g) {
        g.drawImage(select, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Draw options.
     *
     * @param g the g
     */
    private void drawOptions(Graphics g) {
        g.drawImage(options, X, Y, this);
        Toolkit.getDefaultToolkit().sync();
    }


	/**
	 * Gets the options.
	 *
	 * @return the options
	 */
	public Image getOptions() {
		return options;
	}

	/**
	 * Load options.
	 */
	public void loadMultiplayerOptions() {
        ImageIcon ii = new ImageIcon(Resources.getBasePath()+Resources.getIconsPath()+"options.png");
        options = ii.getImage();	}

	/**
	 * Load options.
	 */
	public void loadOptions() {
        ImageIcon ii = new ImageIcon(Resources.getBasePath()+Resources.getIconsPath()+"options.png");
        options = ii.getImage();	}
    }
