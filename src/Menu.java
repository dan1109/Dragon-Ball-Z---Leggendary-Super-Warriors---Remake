/**
 * @author Daniele Bufalo
 * @version 1.0
 */

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import javafx.scene.image.Image;

//fonts:
//https://translate.google.it/translate?hl=it&sl=en&tl=it&u=http%3A%2F%2Fwww.ntu.edu.sg%2Fhome%2Fehchua%2Fprogramming%2Fjava%2FJ8c_PlayingSound.html&anno=2

//this class is the true main class
 /**
 * The Class SoundClipTest.
 */
 public class Menu extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

    /** The panel. */
    private JPanel panel;	//save current panel

    /** The label. */
    private JLabel label;	//save current label
	/**
	 * Instantiates a new sound clip test.
	 *
	 * @throws LineUnavailableException the line unavailable exception
	 */

	// Constructor
    public Menu() throws LineUnavailableException {
    	allWorkDone();	//comment allWOrkDone to test other class
        }

    /**
     * true main lol
     * @throws LineUnavailableException
     */
    public void allWorkDone() throws LineUnavailableException
    {
    	//its true main
    	String menu="\\resources\\images\\Icons\\menu.png";
    	String menustart="\\resources\\images\\Icons\\menu+start.png";
    	//String pressStart="\\resources\\images\\Icons\\menu-press start.png";
    	String soundmenu="resources\\sounds\\03 BGM #03.wav";
    	launch();
    	Sounds.playwav(soundmenu);	//playmusic launch
    	firstWindow();
    	afterLaunch(menu,menustart,800,10);	//500 mlsec, 20 times while
    }
    /**
     * Launch.
     * @throws LineUnavailableException
     */
    public void launch() throws LineUnavailableException
    {	//initialize window, then add image
    	String launch="\\resources\\images\\Icons\\start.png";
    	String launchsound="resources\\sounds\\Gameboy Startup Sound.wav";
    	firstWindow(); //its nonsense! if you delete window(); clip.start have 1 second of duration, bhoooo
    	windowImage(launch);
    	Sounds.playwav(launchsound);	//playmusic launch
    	sleep(3000);
    }

    /**
     * it's an animation of two images in a particular time.
     *
     * @param image1 the image 1
     * @param image2 the image 2
     * @param time  (in millisec)
     * @throws LineUnavailableException
     */
    //there are bugs in animation !
    public void afterLaunch(String image1,String image2,int time,int count) throws LineUnavailableException
    {	int i=0;
	    windowImage(image1);
    	while(i<count)
    	{
    		sleep(time);
    		windowImage(image2);
    		System.out.print(",anim2   ");
    		sleep(time);
    		windowImage(image1);
    		System.out.print("anim1");
    		i++;
    		System.out.print("  "+i+"\n");
    	}
    	windowImage(image1);	//immagine fine animazione start
    	System.out.println("end animation");
    }

    /**
     * Sleep.
     *
     * @param time the time
     */
    public void sleep(int time)
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
        public void SetWindow(String title,String image,int width,int length)
        {	//width is larghezza
        	JPanel panel = new JPanel();
            JLabel label = new JLabel();

        	String basePath = new File("").getAbsolutePath();
        	ImageIcon icon = new ImageIcon(basePath+image);
            label.setIcon(icon);
            panel.add(label);

            this.setTitle(title);
            this.setSize(width, length);	//size of original menu 500x450 , now  500x465
            this.setResizable(false);
            this.getContentPane().add(panel);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	this.setVisible(true);

        	setPanel(panel);
        	setLabel(label);
        }
        /**
         * FirstWindow of menu.
         */
        public void firstWindow()
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

        	setPanel(panel);
        	setLabel(label);
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

        	String basePath = new File("").getAbsolutePath();
        	ImageIcon icon = new ImageIcon(basePath+image);
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
         public void windowImageResize(String image){

         	String basePath = new File("").getAbsolutePath();
         	ImageIcon icon = new ImageIcon(basePath+image);
            label.setIcon(icon);
            panel.add(label);
         	this.getContentPane().add(panel);
         	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         	this.setVisible(true);
         	this.setResizable(true);  //a test
         }

        public void SetOnlyWindow(String title,int width,int length)
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

        	setPanel(panel);
        	setLabel(label);
        }
	/**
	 * Gets the panel.
	 *
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * Sets the panel.
	 *
	 * @param panel the new panel
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public JLabel getLabel() {
		return label;
	}

	/**
	 * Sets the label.
	 *
	 * @param label the new label
	 */
	public void setLabel(JLabel label) {
		this.label = label;
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
