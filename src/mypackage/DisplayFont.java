package mypackage;
import java.awt.*;
import javax.swing.*;
import java.net.URL;

/**
 * This class take a txt font for JComponent from Filepath
 * @author Daniele
 *
 */
class DisplayFont {

	private String abc_path;
	private Font font_path;

	DisplayFont() throws Exception
	{
    	getFont();
    	setFontLabelMessage();
	}

	public void getFont()  throws Exception
	{
		ConvertFilePathToURL conv=new ConvertFilePathToURL();
    	String url=conv.ConvertPathinURL(conv.basePath+conv.resourcesPath+"Fonts\\"+"pkmn rbygsc.ttf");
        URL fontUrl = new URL(url.toString());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
        font = font.deriveFont(Font.PLAIN,20);
        GraphicsEnvironment ge =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        font_path=font;
        abc_path=conv.basePath+conv.resourcesPath+"Fonts\\"+"pkmn rbygsc.ttf";
	}
	public void setFontLabelMessage()
	{
        //esempio di label con font settato
        JLabel l = new JLabel(
            "The quick brown fox jumps over the lazy dog. 0123456789");
        l.setFont(font_path);
        JOptionPane.showMessageDialog(null, l);
	}

    public static void main(String[] args) throws Exception {
    	new DisplayFont();
    }
}
