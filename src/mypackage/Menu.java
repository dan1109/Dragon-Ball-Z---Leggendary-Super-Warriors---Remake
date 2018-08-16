package mypackage;
/**
 * @author Daniele Bufalo
 * @version 1.0
 */
import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

//fonts:
//https://translate.google.it/translate?hl=it&sl=en&tl=it&u=http%3A%2F%2Fwww.ntu.edu.sg%2Fhome%2Fehchua%2Fprogramming%2Fjava%2FJ8c_PlayingSound.html&anno=2

 /**
 * The Class SoundClipTest.
 */
 public class Menu extends JFrame {
	 /**
	  * if press START animation of menu is interrupted
	  */
	private boolean startmenu=false;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The constructor, that  Override KeyEvent for Play !!
	 * we add a KeyListener to play in menu constructor
	 * @throws LineUnavailableException
	 */
    public Menu() throws LineUnavailableException {
    	  		addKeyListener(new KeyListener() {
    			@Override
    			public void keyTyped(KeyEvent e) {
    			}

    			@Override
    			public void keyReleased(KeyEvent e) {
    			}

    			@Override
    			public void keyPressed(KeyEvent e) {
    				if ((e.getKeyCode() == KeyEvent.VK_ENTER)) {
    					setTrue(startmenu);
    				}
    			}
    		});
    		setFocusable(true);
    		//finally adding the test function
    		//allWorkDone();	//comment allWOrkDone to test other class
    	}

	/**set startmenu to true*/
	public void setTrue(boolean x)
	{
		x=true;
	}

    /** A copy of MeunuFrame.java*/
    private void initUI() {

        add(new Select());
        setResizable(false);
        pack();
        setTitle("Select");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    /**
     * true main lol
     * @throws LineUnavailableException
     */
    public void allWorkDone() throws LineUnavailableException
    {
    	String menu="\\resources\\images\\Icons\\menu.png";
    	String menustart="\\resources\\images\\Icons\\menu+start.png";
    	//String start="\\resources\\images\\Icons\\start-icon.png";	//only start button
    	String soundmenu="resources\\sounds\\03 BGM #03.wav";
    	launch();
    	Sounds.playwav(soundmenu);	//playmusic launch
    	titleWindowEmpty();
    	switchStart(menu,menustart,800,10);	//500 mlsec, 20 times while
    }
    /**
     * Launch.
     * @throws LineUnavailableException
     */
    public void launch() throws LineUnavailableException
    {
    	String launch="\\resources\\images\\Icons\\start.png";
   	    titleWindowEmpty();//its nonsense! if you delete window(); clip.start have 1 second of duration, bhoooo
		windowImage(launch);
       	String launchsound="resources\\sounds\\Gameboy Startup Sound.wav";
       	Sounds.playwav(launchsound);	//playmusic launch
    	sleep(3000);
    }

    /**
     * it's an animation of two images in a particular time.
     * It's looped but if you press start is interrupted. Working!
     *
     * @param image1 the image 1
     * @param image2 the image 2
     * @param time  (in millisec)
     * @throws LineUnavailableException
     */
    public void switchStart(String backgroundImage,String imageUp,int time,int count) throws LineUnavailableException
    {	String options="\\resources\\images\\Icons\\options.png";
    	String sound="resources\\sounds\\Press Start sound effect.wav";
    	int i=0;
    	while(startmenu!=true)
    	{
    		windowImage(backgroundImage);
    		sleep(time);
    		windowImage(imageUp);
    		sleep(time);
    	}
		Sounds.playwav(sound);
    	while(i<3)
    	{
    		windowImage(backgroundImage);
    		sleep(time/3);
    		windowImage(imageUp);
    		sleep(time/3);
    		i++;
    	}
		//windowImage(options);
    }

    /**
     * Sleep.
     *
     * @param time the time
     */
    public static void sleep(int time)
    {
        //sleep for a bit
        try {
            Thread.sleep(time);	//in millisec
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }    /**
         * a general method to customize title, width and length
         * of a first generic Window adding an image
         * @param title
         * @param width
         * @param length
         * @param image
         */
        public void setTitleWindowImage(String title,String image,int width,int length)
        {	//width is larghezza
        	JPanel panel = new JPanel();
            JLabel label = new JLabel();

        	ImageIcon icon = new ImageIcon(getCompletePath(image));
            label.setIcon(icon);
            panel.add(label);

            this.setTitle(title);
            this.setSize(width, length);	//size of original menu 500x450 , now  500x465
            this.setResizable(false);
            this.getContentPane().add(panel);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	this.setVisible(true);

        }
        /**
         * FirstWindow of menu.
         */
        public void titleWindowEmpty()
        {
        	JPanel panel = new JPanel();
            JLabel label = new JLabel();
            panel.add(label);

            String title="DBZ - Legendary Super Warrior - remake by dan1109";
            this.setTitle(title);
            this.setSize(500, 465);	//size of original menu 500x450 , now  500x465
            this.setResizable(false);
            this.getContentPane().add(panel);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	this.setVisible(true);

        }

       /**
        * Window menu.
        * show the image passed as arguments
        * but it isn't resizable
        *
        * @param image the image
        * @throws LineUnavailableException
        */
        public void windowImage(String image){
        	ImageIcon icon = new ImageIcon(getCompletePath(image));
    		JPanel panel= new JPanel();
    		JLabel label= new JLabel();
            label.setIcon(icon);
            panel.add(label);
        	this.getContentPane().add(panel);
        	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	this.setVisible(true);
        	//this.setResizable(true);  //a test
        }
        /**
         * Window menu.
         * show the image passed as arguments
         * but resizable
         *
         * @param image the image
         * @throws LineUnavailableException
         */
         public void windowImageResizable(String image){

         	ImageIcon icon = new ImageIcon(getCompletePath(image));
    		JPanel panel= new JPanel();
    		JLabel label= new JLabel();
            label.setIcon(icon);
            panel.add(label);
         	this.getContentPane().add(panel);
         	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         	this.setVisible(true);
         	this.setResizable(true);  //a test
         }

        public void setOnlyTitleEmptyWindow(String title,int width,int length)
        {
        	//width is larghezza
        	JPanel panel = new JPanel();
            JLabel label = new JLabel();

            panel.add(label);

            this.setTitle(title);
            this.setSize(width, length);	//size of original menu 500x450 , now  500x465
            this.setResizable(false);
            this.getContentPane().add(panel);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	this.setVisible(true);
        }

        public static String getCompletePath(String relative)
        {
        	String basePath = new File("").getAbsolutePath();
        	return basePath+relative;
        }

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws LineUnavailableException the line unavailable exception
     */
    //l'eseguibile
        public static void main(String[] args) throws LineUnavailableException {
           new Menu();
        }
 }
