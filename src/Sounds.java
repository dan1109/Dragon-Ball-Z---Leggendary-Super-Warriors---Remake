import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * This class reproduce Sounds of dir
 * resources\sounds\...
 * @author Daniele
 *
 */
public class Sounds {
	private String tempname;
	/**
	 * if the sound doesnt exit, return index -1,+
	 * else return index of correct sound
	 * @param x
	 * @param y
	 * @return
	 * @throws LineUnavailableException
	 */
	public static void main(String args[]) throws LineUnavailableException
	{
		new Sounds();
	}
	Sounds() throws LineUnavailableException
	{
		BeforeMenu();
	}
	/**
	 * Testing the duration of wav sound in Panel,Label.
	 * Yes confirm without a window the duration is equal to 1 second and i don't
	 * know why
	 * @throws LineUnavailableException
	 */
	public void TestwavPanelLabel() throws LineUnavailableException
	{
		Menu menu = null;
        menu = new Menu();
		menu.SetOnlyWindow("Test", 0, 0); //to play music see menu.java launch();
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

	public int SearchMusic(Resources x,String y)
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
	public void BeforeMenu() throws LineUnavailableException
	{
		this.setTempname("01 BGM #01.wav");
		Resources music=new Resources();
		music.getFilesDir("sounds");
		Menu menu=new Menu();
		int found= this.SearchMusic(music,this.getTempname());
		String output=music.getFileRelativePath(found);

		TestwavPanelLabel();
		playwav(output);
		System.out.println(output);  //example: resources\sounds\01 BGM #01.wav
	}
	public String getTempname() {
		return tempname;
	}
	public void setTempname(String tempname) {
		this.tempname = tempname;
	}
}
