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
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;


// TODO: Auto-generated Javadoc
//working
/**
 * This class get names and path to open png and sound
 * for sounds
 * relative pathe start from
 * resources..
 * for png
 * \resources...
 *
 * WORKING for every path in every project and dyr. 14-08-18
 * @author Daniele
 *
 */
public class Resources {

	/** The base path. */
	private static final String basePath = new File("").getAbsolutePath();

	/** The Constant resourcesPath. */
	private static final String resourcesPath="\\resources\\";

	/** The sounds. */
	private static final String soundsPath=resourcesPath+"sounds\\";

	/** The images. */
	private static final String imagesPath=resourcesPath+"images\\";

	/** The icons. */
	private static final String iconsPath=imagesPath+"Icons\\";
	
	/** The icons. */
	private static final String videosPath=resourcesPath+"videos\\";

	/** The portrait. */
	private static final String portraitPath=imagesPath+"Portrait\\";

	/** The name list. */
	private static ArrayList<String> nameList;	//list to safe files of a specific dyr..

	/**
	 * Gets the base path.
	 *
	 * @return the base path
	 */
	public static String getBasePath()
	{
		return basePath;
	}

	/**
	 * Gets the icons path.
	 *
	 * @return the icons path
	 */
	public static String getIconsPath()
	{
		return iconsPath;
	}

	/**
	 * Gets the sounds path.
	 *
	 * @return the icons path
	 */
	public static String getSoundPath()
	{
		return soundsPath.substring(1);	//playwav( resources//...) not //resources//..
	}

	/**
	 * Testing image.
	 */
	public static void testingImage()
	{
		String test="icons";
		Resources.getFilesDir(test);
		String output=getFileRelativePath(3);
		print(output);
		try {
			Menu a = new Menu();
			a.windowImage(output);
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();}
	}

	/**
	 * testing sound of this class.
	 */
	public static void testingSound()
	{
		/*
		 * You can chose between:
		 * icons,
		 * portrait,
		 * sounds.
		 */

	 String test="sounds";
	Resources.getFilesDir(test);
	String sound=getFileRelativePath(5);
	try {
		Sounds b= new Sounds();
		b.PlayWavInEmptyWindow(sound);
	} catch (LineUnavailableException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}


	/**
	 * has only initList().
	 * be careful to delete testing Image and Sound
	 */
	Resources()
	{
		initList();
		testingSound();
		//testingImage();
	}

	/**
	 * Adds the.
	 *
	 * @param x the x
	 */
	public static void add(String x)
	{
		nameList.add(x);
	}

	/**
	 * a generic method to print a generic parameter.
	 *
	 * @param <T> the generic type
	 * @param x the x
	 */
	public static<T> void print(T x)
	{
		System.out.println(x);
	}

	/**
	 * Gets the files dir.
	 *
	 * @param x the x
	 * @return the files dir
	 */
	public static void getFilesDir(String x)
	{
		String temp=null;
		if(x.equals("icons"))
		{
			temp=basePath+iconsPath;
		}
		else if(x.equals("sounds"))
		{
			temp=basePath+soundsPath;
		}
		else if(x.equals("portrait"))
		{
			temp=basePath+portraitPath;
		}
		//print(temp);
		File folder = new File(temp);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			nameList.add(temp+listOfFiles[i].getName());
			}

	}

	/**
	 * Inits the list.
	 */
	public static void initList()
	{
		nameList = new ArrayList<String>();
	}

	/**
	 * Dim.
	 *
	 * @return the int
	 */
	public static int dim()
	{
		return nameList.size();
	}

	/**
	 * Take the relative path for open file.
	 * For example in sounds is particular the length considerated
	 *
	 * @param pos the pos
	 * @return the file relative path
	 */
	public static String getFileRelativePath(int pos)
	{
		// \\resources\\... can't play. only if start with resources\\...
		if(nameList.get(pos).contains(soundsPath))
		{
			return nameList.get(pos).substring(basePath.length(), nameList.get(pos).length()).substring(1);
		}
		return nameList.get(pos).substring(basePath.length(), nameList.get(pos).length());
	}

	/**
	 * return all path of element in pos.
	 *
	 * @param pos the pos
	 * @return the a name list
	 */
	public static String getANameList(int pos)
	{
		return nameList.get(pos);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws LineUnavailableException the line unavailable exception
	 */
	public static void main(String args[]) throws LineUnavailableException
	{
		//testing
		new Resources();

	}
}
