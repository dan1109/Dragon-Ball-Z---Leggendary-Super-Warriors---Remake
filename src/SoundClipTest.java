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

 // To play sound using Clip, the process need to be alive.
 /**
 * The Class SoundClipTest.
 */
// Hence, we use a Swing application.
 public class SoundClipTest extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new sound clip test.
	 *
	 * @throws LineUnavailableException the line unavailable exception
	 */
	// Constructor
    public SoundClipTest() throws LineUnavailableException {
    	windowMenu();
    	playwavmenu();	//playmusic menu
        }

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws LineUnavailableException the line unavailable exception
     */
    //l'eseguibile
        public static void main(String[] args) throws LineUnavailableException {
           new SoundClipTest();
        }

        /**
         * Window menu.
         */
        public void windowMenu(){
    String basePath = new File("").getAbsolutePath();
    String menu="\\resources\\images\\Icons\\menu.png";
    //System.out.println(basePath);	//C:\Users\Daniele\workspace\Dragon Ball Z - leggendary super warrior-remake

    JPanel panel = new JPanel();
    ImageIcon icon = new ImageIcon(basePath+menu);
    JLabel label = new JLabel();
    label.setIcon(icon);
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
 	    * Playwavmenu.
 	    */
 	   public void playwavmenu()
   	 {
   		 try {
   	    	   // from a wave File
   	    	  File soundFile = new File("resources\\sounds\\03 BGM #03.wav");	//menu sound
   	    	  AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
   	    	   // Get a sound clip resource.
   	           Clip clip = AudioSystem.getClip();
   	           // Open audio clip and load samples from the audio input stream.
   	           clip.open(audioIn);
   	           clip.loop(Clip.LOOP_CONTINUOUSLY);  // repeat forever
   	           } catch (UnsupportedAudioFileException e) {
   	               e.printStackTrace();
   	           } catch (IOException e) {
   	              e.printStackTrace();
   	           } catch (LineUnavailableException e) {
   	              e.printStackTrace();
   	           }
   	 }
 }
