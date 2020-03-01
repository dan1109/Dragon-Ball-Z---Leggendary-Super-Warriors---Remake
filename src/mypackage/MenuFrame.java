/**
 * @author Daniele Bufalo

 * @version 1.0
 */
package mypackage;
import javax.swing.JFrame;
import Keyboard.KeyListeners;

/**
 * The Class MenuFrame.
 */
public class MenuFrame extends JFrame {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new menu frame.
	 */
	public MenuFrame() {
    	initUI();
		}

    /**
     * Inits the UI.
     */
    private void initUI() {
    	/*this configuration :
    	 * create a variable Select s,
    	 * use s as input of k object in OptionsKey,
    	 * repaint in Select class
    	 *
    	 * working!!!
    	*/
    	Select s=new Select();
    	KeyListeners k= new KeyListeners();
    	k.OptionsKey(s);	//there is a package error
    	addKeyListener(k.getOptions());	//adding menu keys, working
    	add(s);

        setResizable(false);
        pack();
        setTitle("MenuFrame call Select");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
    	@SuppressWarnings("unused")
		JFrame ex = new MenuFrame();
    }
}