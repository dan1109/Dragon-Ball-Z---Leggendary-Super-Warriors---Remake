package mypackage;
import javax.swing.JFrame;

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