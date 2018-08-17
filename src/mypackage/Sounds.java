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
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

// TODO: Auto-generated Javadoc
/**
 * This class reproduce Sounds of dir
 * resources\sounds\...
 * @author Daniele
 *
 */
public class Sounds {

	/** The tempname. */
	private String tempname;

	/**
	 * if the sound doesnt exit, return index -1,+
	 * else return index of correct sound.
	 *
	 * @param args the arguments
	 * @throws LineUnavailableException the line unavailable exception
	 */
	public static void main(String args[]) throws LineUnavailableException
	{
		new Sounds();
	}

	/**
	 * Instantiates a new sounds.
	 *
	 * @throws LineUnavailableException the line unavailable exception
	 */
	Sounds() throws LineUnavailableException
	{
		//BeforeMenu();	//working
	}

	/**
	 * Used for Testing the duration of wav sound in Panel,Label.
	 * Yes confirm without a window the duration is equal to 1 second and i don't
	 * know why
	 *
	 * @throws LineUnavailableException the line unavailable exception
	 */
	public static void TestwavPanelLabel() throws LineUnavailableException
	{
		Menu menu = null;
        menu = new Menu();
		menu.setOnlyTitleEmptyWindow("Test", 0, 0); //to play music see menu.java launch();
	}
	 /**
	    * Playwav passing a sound path.
	    *
	    * @param sound the sound
	    */
	   public static void playwav(String sound)
 	 {	//obiuvsly is static method
 		 try {
 	    	  File soundFile = new File(sound);	//menu sound
 	    	  AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
 	           Clip clip = AudioSystem.getClip();
 	           clip.open(audioIn);
 	           clip.start();
 	           //clip.loop(Clip.LOOP_CONTINUOUSLY);  // repeat forever
 	           } catch (UnsupportedAudioFileException e) {
 	               e.printStackTrace();
 	           } catch (IOException e) {
 	              e.printStackTrace();
 	           } catch (LineUnavailableException e) {
 	              e.printStackTrace();
 	           }
 	 }

	/**
	 * Search music.
	 * Return the index of  nameList that contains the string y
	 *
	 * @param x the x
	 * @param y the y
	 * @return the int
	 */
	public static int SearchMusic(Resources x,String y)
	{	int i=0;
		//System.out.println(y); //example: 02 BGM #02.wav
		int dim=x.dim();
		while(i<dim)
		{	if(x.getFileRelativePath(i).contains(y))
			{
				return i;
			}
			i++;
		}
		return -1;
	}

	/**
	 * Before menu.
	 *
	 * @throws LineUnavailableException the line unavailable exception
	 */
	public void BeforeMenu() throws LineUnavailableException
	{
		this.setTempname("01 BGM #01.wav");
		Resources music=new Resources();
		music.getFilesDir("sounds");
		@SuppressWarnings("unused")
		Menu menu=new Menu();
		int found= this.SearchMusic(music,this.getTempname());
		String output=music.getFileRelativePath(found);

		TestwavPanelLabel();
		playwav(output);
		System.out.println(output);  //example: resources\sounds\01 BGM #01.wav
	}

	/**
	 * Play a music after creation of Resources in an other function
	 * for etsting Resources methods.
	 *
	 * @param sound the sound
	 * @throws LineUnavailableException the line unavailable exception
	 */
	public void PlayWavInEmptyWindow(String sound) throws LineUnavailableException
	{
		TestwavPanelLabel();
		playwav(sound);
	}

	/**
	 * Gets the tempname.
	 *
	 * @return the tempname
	 */
	public String getTempname() {
		return tempname;
	}

	/**
	 * Sets the tempname.
	 *
	 * @param tempname the new tempname
	 */
	public void setTempname(String tempname) {
		this.tempname = tempname;
	}
}
