package mypackage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This Class convert a String filepath (wav,png,mp4...) in an openable url by a MediaPlayer
 * See the execution of main's VideoPlayer.java
 * @author Daniele
 */
public class ConvertFilePathToURL {

	/** The base path. */
	  public static final String basePath = new File("").getAbsolutePath();
		/** The Constant resourcesPath. */
	  public static final String resourcesPath="\\resources\\";
	  /** The icons. */
	  public static final String videosPath=resourcesPath+"videos\\";

	  public static final String INIT_URL="file:///";

	  /** A test of example mp4 filename*/
	  public static final String filename="Gameboy Color - Boot Up Screen.mp4";

	  //public static final String VID_URL ="file:///C:/Users/Daniele/eclipse-workspace/Test/resources/videos/Gameboy%20Color%20-%20Boot%20Up%20Screen.mp4";
	  /**
	   * An example of a filepath String
	   */
	  public static String FILE_PATH =basePath+videosPath+filename;

	  /**
	   * Convert a filepath in a open url
	   * for example to play a mp4 or open png wav...
	   * @param path
	   * @throws MalformedURLException
	   */
	public ConvertFilePathToURL() {
		//Resources.print(ConvertPathinURL(path));
	}
	public String ConvertPathinURL(String path) throws MalformedURLException
	{
		File file = new File(path);
		URL url = file.toURI().toURL();
		path=url.toString();
		path=path.replaceAll("file:/",INIT_URL);
		return path;
	}

	/**
	 * Test of method
	 * @param args
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException {
		new ConvertFilePathToURL();
	}

}
