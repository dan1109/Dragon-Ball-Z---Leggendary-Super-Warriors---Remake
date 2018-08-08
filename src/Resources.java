import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;

//working
/**
 * This class get names and path to open png and sound
 * for sounds
 * relative pathe start from
 * resources..
 * for png
 * \resources...
 * @author Daniele
 *
 */
public class Resources {

	private static String basePath = new File("").getAbsolutePath();

	private static String sounds="\\resources\\sounds\\";
	private static String images="\\resources\\images\\";
	private static String icons="icons\\";
	private static String portrait="Portrait\\";
	private int pathLenght;		//lenght of sum of all path ex. base+sound, base-img+icons...
	ArrayList<String> nameList;	//list to safe files of a specific dyr..

	Resources() throws LineUnavailableException
	{	initList();
	/*
	 * You can chose between:
	 * icons,
	 * portrait,
	 * sounds.
	 */
		String test="icons";
		this.getFilesDir(test);
		String output=this.getFileRelativePath(4);
		print(output);
		Menu menu=null;
		menu = new Menu();
    	menu.firstWindow(); //its nonsense! if you delete window(); clip.start have 1 second of duration, bhoooo
    	menu.windowImageResize(output); //working! example:"\\resources\\images\\Icons\\start.png"
	}

	public void add(String x)
	{
		nameList.add(x);
	}
	/**
	 * a generic method to print a generic parameter
	 * @param x
	 */
	public static<T> void print(T x)
	{
		System.out.println(x);
	}
	public void getFilesDir(String x)
	{
		String temp = null;	//initialize
		if(x.equals("icons"))
		{
			temp=basePath+images+icons;
			this.setPathLenght(temp.length());
			this.setPathLenght(84); //example: 85 = "C:\Users\Daniele\Documents\GitHub\Dragon-Ball-Z---Leggendary-Super-Warriors---Remake"

		}
		else if(x.equals("sounds"))
		{
			temp=basePath+sounds;
			this.setPathLenght(85); //example: 85 = "C:\Users\Daniele\Documents\GitHub\Dragon-Ball-Z---Leggendary-Super-Warriors---Remake\"
		}
		else if(x.equals("portrait"))
		{
			temp=basePath+images+portrait;
			this.setPathLenght(temp.length());
		}
		//print(temp);
		File folder = new File(temp);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			nameList.add(temp+listOfFiles[i].getName());
			}
		//print(getSoundRelativePath(0));	//example : resources\sounds\01 BGM #01.wav

	}
	public void initList()
	{
		nameList = new ArrayList<String>();
	}
	public int getPathLenght() {
		return pathLenght;
	}
	public void setPathLenght(int x) {
	    this.pathLenght=x;
	}
	public int dim()
	{
		return nameList.size();
	}
	/**
	 * Take the relative path for open file.
	 * For example in sounds is particular the length considerated
	 * @param pos
	 * @return
	 */
	public String getFileRelativePath(int pos)
	{
		return nameList.get(pos).substring(pathLenght);
	}
	/**
	 * return all path of element in pos
	 * @param pos
	 * @return
	 */
	public String getANameList(int pos)
	{
		return nameList.get(pos);
	}
	public static void main(String args[]) throws LineUnavailableException
	{
		//testing
		new Resources();

	}
}
