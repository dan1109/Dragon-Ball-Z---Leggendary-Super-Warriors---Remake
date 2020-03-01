/**
 * @author Daniele Bufalo
 * @version 1.0
 */
package mypackage;
/**
 * @author Daniele Bufalo
 * @version 1.0
 */
import java.io.File;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Keyboard.KeyListeners;

// TODO: Auto-generated Javadoc
//fonts:
//https://translate.google.it/translate?hl=it&sl=en&tl=it&u=http%3A%2F%2Fwww.ntu.edu.sg%2Fhome%2Fehchua%2Fprogramming%2Fjava%2FJ8c_PlayingSound.html&anno=2

 /**
 * The Class SoundClipTest.
 */
 public class Menu extends JFrame {

 	/** if press START animation of menu is interrupted. */
	private boolean startmenu=false;

	public boolean getStartMenu()
	{
		return startmenu;
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The constructor, that  Override KeyEvent for Play !!
	 * we add a KeyListener to play in menu constructor.
	 *
	 * @throws LineUnavailableException the line unavailable exception
	 */
    public Menu() throws LineUnavailableException {
    	KeyListeners k= new KeyListeners();
    	k.menuKey(this);	//passing menu
    	addKeyListener(k.getMenu());

    	allWorkDone();	//comment allWOrkDone to test other class
    	}

	/**
	 * set startmenu to true.
	 *
	 * @param x the new true
	 */
	public void setTrue()
	{
		startmenu=true;
	}

    /**
     * true main lol.
     *
     * @throws LineUnavailableException the line unavailable exception
     */
    public void allWorkDone() throws LineUnavailableException
    {
    	String menu="\\resources\\images\\Icons\\menu.png";
    	String menustart="\\resources\\images\\Icons\\menu+start.png";
    	//String start="\\resources\\images\\Icons\\start-icon.png";	//only start button
    	String soundmenu="resources\\sounds\\03 BGM #03.wav";
    	VideoPlayer v = new VideoPlayer();
    	v.playMp4();//play game boy animation with pliiinn sound
    	launch();
    	Sounds.playwav(soundmenu);	//playmusic launch
    	switchStart(menu,menustart,800,10);	//500 mlsec, 20 times while
    	afterPressStart();	//show options
    }

    /**
     * Launch.
     *
     * @throws LineUnavailableException the line unavailable exception
     */
    public void launch() throws LineUnavailableException
    {
    	String launch="\\resources\\images\\Icons\\start.png";
   	    titleWindowEmpty();//its nonsense! if you delete window(); clip.start have 1 second of duration, bhoooo
		windowImage(launch);
		Menu.sleep(3000);
    }

    /**
     * it's an animation of two images in a particular time.
     * It's looped but if you press start is interrupted. Working!
     *
     * @param backgroundImage the background image
     * @param imageUp the image up
     * @param time  (in millisec)
     * @param count the count
     * @throws LineUnavailableException the line unavailable exception
     */
    public void switchStart(String backgroundImage,String imageUp,int time,int count) throws LineUnavailableException
    {
    	String sound=Resources.getSoundPath()+"Start.wav";
    	int i=0;
    	while(startmenu!=true)
    	{
    		windowImage(backgroundImage);
    		sleep(time);
    		windowImage(imageUp);
    		sleep(time);
    	}
    	i=0;
		Sounds.playwav(sound);
    	while(i<3)
    	{
    		windowImage(backgroundImage);
    		sleep(time/3);
    		windowImage(imageUp);
    		sleep(time/3);
    		i++;
    	}
    }

    /**
     * Use select keylistener and show options
     */
    public void afterPressStart()
    {
    	Select s=new Select();
    	KeyListeners k= new KeyListeners();

    	k.removeKeyMenuListener();//remove menu comand
    	k.OptionsKey(s);	//add options menu comand
    	addKeyListener(k.getOptions());
    	add(s);

    	s.initBoard();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
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
    }
    /**
     * a general method to customize title, width and length
     * of a first generic Window adding an image.
     *
     * @param title the title
     * @param image the image
     * @param width the width
     * @param length the length
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
            setLocationRelativeTo(null);	//Winodw in centre of screen
        }

       /**
        * Window menu.
        * show the image passed as arguments
        * but it isn't resizable
        *
        * @param image the image
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
        }

        /**
         * Window menu.
         * show the image passed as arguments
         * but resizable
         *
         * @param image the image
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

        /**
         * Sets the only title empty window.
         *
         * @param title the title
         * @param width the width
         * @param length the length
         */
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

        /**
         * Gets the complete path.
         *
         * @param relative the relative
         * @return the complete path
         */
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
