package mypackage;
import java.io.File;
import java.net.MalformedURLException;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import javafx.application.Platform;
import javafx.beans.value.*;
import javafx.embed.swing.JFXPanel;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.media.*;
import javafx.util.Duration;

public class VideoPlayer extends JFrame {

	 private static final long serialVersionUID = 1L;
	/** The base path. */
	  public static final String basePath = new File("").getAbsolutePath();
		/** The Constant resourcesPath. */
	  public static final String resourcesPath="\\resources\\";
	  /** The icons. */
	  public static final String videosPath=resourcesPath+"videos\\";

	  public static final String INIT_URL="file:///";

	  /** A test of example mp4 filename*/
	  public static final String filename="Gameboy Color - Boot Up Screen.mp4";

	  /**
	   * An example of a filepath String
	   */
	  public static String FILE_PATH =basePath+videosPath+filename;

  //Sizes of panel and frame
  private static final int VID_WIDTH     = 500;//320
  private static final int VID_HEIGHT    = 450;//180
  private static final int PLAYER_WIDTH  = 500;//320
  private static final int PLAYER_HEIGHT = 465;//265

  private void play(final String url) {


    final JFXPanel panel = new JFXPanel();
    Platform.runLater(new Runnable() {
      @Override public void run() {
    initFX(panel, url);
      }
    });
    String title="DBZ - Legendary Super Warrior - remake by dan1109";
    this.setTitle(title);
    this.add(panel);
    this.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);
    /*
     * sleep= duration of intro=4000. I dont know how get the
     * info duration
     */
    Menu.sleep(4000);
    /*
     * close mp4 video intro
     */
	this.setVisible(false);
	this.dispose();
	}


  private void initFX(JFXPanel panel, String url) {
    MediaView mediaView = createMediaView(url);

    final Scene playerScene = new Scene(
      createPlayerLayout(mediaView),
      PLAYER_WIDTH,
      PLAYER_HEIGHT
    );

    setMediaEventHandlers(
      mediaView
    );

    panel.setScene(playerScene);
  }

  private MediaView createMediaView(String url) {
    final Media clip = new Media(url);
    final MediaPlayer player = new MediaPlayer(clip);
    final MediaView view = new MediaView(player);
    view.setFitWidth(VID_WIDTH);
    view.setFitHeight(VID_HEIGHT);
    return view;
  }

  private VBox createPlayerLayout(final MediaView view) {
    view.getMediaPlayer().play();
;

    final VBox layout = new VBox(8);
    layout.setAlignment(Pos.CENTER);
    layout.getChildren().addAll(
      view
    );
    return layout;
  }

  private void setMediaEventHandlers(final MediaView view) {
    final MediaPlayer player = view.getMediaPlayer();

    Resources.print("Initial: " + player.getStatus());
    player.statusProperty().addListener(new ChangeListener<MediaPlayer.Status>() {
      @Override
      public void changed(ObservableValue<? extends MediaPlayer.Status> observable, MediaPlayer.Status oldStatus, MediaPlayer.Status curStatus) {
    	  Resources.print("Current: " + curStatus);
      }
    });

    if (player.getError() != null) {
    	Resources.print("Initial Error: " + player.getError());
    }

    player.setOnError(new Runnable() {
      @Override public void run() {
        Resources.print("Current Error: " + player.getError());
      }
    });
  }

  /**
   * this is the principal function that play an mp4
   */
  public void playMp4()
  {
  	VideoPlayer player = new VideoPlayer();
  	try {

			ConvertFilePathToURL a= new ConvertFilePathToURL();
			FILE_PATH=a.ConvertPathinURL(FILE_PATH);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	    player.play(FILE_PATH);//VID_URL
  }

  public static void main(String[] args) {

      }
    };
