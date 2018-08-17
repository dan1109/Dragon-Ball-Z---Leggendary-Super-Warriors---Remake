/**
 * @author Daniele Bufalo
 * @version 1.0
 */
package Keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

import mypackage.Select;
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
				  s.selectDown();
	           }
			  if((e.getKeyCode() == KeyEvent.VK_UP))
	           	{
   				  s.selectUp();
	           	}
			  if((e.getKeyCode() == KeyEvent.VK_ENTER))
	           {
				  if(s.y==301)
				  {
					  Resources.print("Continua gioco!");
				  }
				  else if(s.y==326)
				  {
					  Resources.print("Multigiocatore!");
				  }
				  else if(s.y==351)
				  {
					  Resources.print("Battaglia!");
				  }
				  else if(s.y==376)
				  {
					  Resources.print("Rinizia daccapo!");
				  }
	           }
			}
		};
		setFocusable(true);//end methods keylistener
	}

}

