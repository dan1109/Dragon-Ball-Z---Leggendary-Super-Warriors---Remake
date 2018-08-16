package OverlayImg;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import mypackage.Resources;	//i renamed default package in mypackage cause it's better for import!!!

/**Work perfectly!*/
public class Select extends JPanel {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private final int B_WIDTH = 500;
    private final int B_HEIGHT = 450;

    //There are important! INITIAL X and Y!!
    private final int INITIAL_X = 125;//-40
    private final int INITIAL_Y = 301;//-40

    private final int Y_HEIGHT = 381;//-40

    /** x y for background*/
    private final int X = 0;//-40
    private final int Y = 0;//-40

    private Image options;
    private Image select;
    private int x, y;

    public static void main(String[] args)
    {
    	new Select();
    }

    Select()
    {
    		initBoard();
    	    addKeyListener(new KeyListener() {
    			@Override
    			public void keyTyped(KeyEvent e) {
    			}

    			@Override
    			public void keyReleased(KeyEvent e) {
    				System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
    				}

    			@Override
    			public void keyPressed(KeyEvent e) {
    				System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
    			  if((e.getKeyCode() == KeyEvent.VK_DOWN))
    	           {
    				  selectDown();
    	           }
    			  if((e.getKeyCode() == KeyEvent.VK_UP))
   	           		{
       				  selectUp();
   	           		}
    			}
    		});
    		setFocusable(true);
    }


    public void selectUp()
    {
    	  y-=25;
			if(y<=INITIAL_Y)
			{
				y=INITIAL_Y;
			}
			repaint();
    }
    public void selectDown()
    {
    		y+=25;
	        if (y > Y_HEIGHT) {
	            y = INITIAL_Y;
	        }
	        repaint();
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon(Resources.getBasePath()+Resources.getIconsPath()+"select.png");
        select = ii.getImage();
    }

    private void initBoard() {

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setDoubleBuffered(true);


        //after we press START...
        loadOptions();
        loadImage();

        x = INITIAL_X;
        y = INITIAL_Y;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawOptions(g);
        drawSelect(g);
    }

    private void drawSelect(Graphics g) {

        g.drawImage(select, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawOptions(Graphics g) {

        g.drawImage(options, X, Y, this);
        Toolkit.getDefaultToolkit().sync();
    }


	public Image getOptions() {
		return options;
	}

	public void loadOptions() {
        ImageIcon ii = new ImageIcon(Resources.getBasePath()+Resources.getIconsPath()+"options.png");
        options = ii.getImage();	}
    }
