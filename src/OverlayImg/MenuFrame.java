package OverlayImg;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;
import mypackage.Menu;	//i renamed default package in mypackage cause it's better for import!!!


public class MenuFrame extends JFrame {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public MenuFrame() {

        initUI();
    }

    private void initUI() {

        add(new Select());
        setResizable(false);
        pack();
        setTitle("Select");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {

    	@SuppressWarnings("unused")
		JFrame ex = new MenuFrame();
    }
}