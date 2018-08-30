/**
 * @author Daniele Bufalo
 * @version 1.0
 */
package Keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

import mypackage.Select;
import mypackage.Sounds;
import mypackage.Menu;
import mypackage.Resources;

// TODO: Auto-generated Javadoc
/**
 * The Class KeyListeners.
 */
public class KeyListeners extends JPanel{

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The menu. */
	 private static KeyListener menu;

	/** The options. */
	 private static  KeyListener options;
	 /** The choose mode with press Enter. */
	 private boolean OptionEnter=false;
	 /** The choose mode with press Enter in Multiplayer */
	 private boolean MultiEnter=false;

	 public KeyListener getOptions()
	 {
		 return options;
	 }

	 public KeyListener getMenu()
	 {
		 return menu;
	 }

	/**
	 * Removes the key menu listener.
	 */
	public void removeKeyMenuListener()
	{
		removeKeyListener(menu);
	}

	/**
	 * Removes the key options listener.
	 */
	public void removeKeyOptionsListener()
	{
		removeKeyListener(options);
	}

	/** set all comands*/
	public KeyListeners()
	{
		//empty
	}

	/**
	 * Menu key.
	 */
	public void menuKey(Menu m)
	{
		//set private listener
		menu= new KeyListener()
		{
			//@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_ENTER)) {
					m.setTrue();
				}
			}
		};//end methods keylistener
	}

	/**
	 * Options key.
	 * a is a Select object in input of mypackage
	 */
	public void OptionsKey(Select s)
	{	//set private listener
		options= new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			  if((e.getKeyCode() == KeyEvent.VK_DOWN))
	           {
				  Sounds.playwav(Resources.getSoundPath()+"direction.wav");
				  s.selectDown();
	           }
			  if((e.getKeyCode() == KeyEvent.VK_UP))
	           	{
				  Sounds.playwav(Resources.getSoundPath()+"direction.wav");
   				  s.selectUp();
	           	}
			  if((e.getKeyCode() == KeyEvent.VK_ENTER))
	           {
				  if(s.y==301)
				  {
					  Sounds.playwav(Resources.getSoundPath()+"A.wav");
					  Resources.print("Continua gioco!");
					  setOptionEnterTrue();
				  }
				  else if(s.y==326)
				  {
					  Sounds.playwav(Resources.getSoundPath()+"A.wav");
					  Resources.print("Multigiocatore!");
					  setOptionEnterTrue();
					  //something...
					  //setMultiEnterTrue();
				  }
				  else if(s.y==351)
				  {
					  Sounds.playwav(Resources.getSoundPath()+"A.wav");
					  Resources.print("Battaglia!");
					  setOptionEnterTrue();
				  }
				  else if(s.y==376)
				  {
					  Sounds.playwav(Resources.getSoundPath()+"A.wav");
					  Resources.print("Rinizia daccapo!");
					  setOptionEnterTrue();
				  }
	           }
			}
		};
		setFocusable(true);//end methods keylistener
	}

	public boolean getOptionEnter() {
		return OptionEnter;
	}

	public void setOptionEnterTrue() {
		OptionEnter = true;
	}

	public boolean getMultiEnter() {
		return MultiEnter;
	}

	public void setMultiEnterTrue() {
		MultiEnter = true;
	}

}

