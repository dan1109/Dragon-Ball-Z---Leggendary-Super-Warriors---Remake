/**
 * @author Daniele Bufalo
 * @version 1.0
 */
package mypackage;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// TODO: Auto-generated Javadoc
/**
 * The Class ResizeImg.
 */
/*
 * @author mkyon
 *
 *See:
 *https://www.mkyong.com/java/how-to-resize-an-image-in-java/
 *
 *it's working!
 */
public class ResizeImg {

	/** width of resized image. */
	private static final int IMG_WIDTH = 500;
	
	/** height of resized image. */
	private static final int IMG_HEIGHT = 450;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String [] args){

	try{
		String path="C:\\Users\\Daniele\\eclipse-workspace\\Test\\resources\\images\\Icons\\";
		String img="battle option.PNG";

		BufferedImage originalImage = ImageIO.read(new File(path+img));
		int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
		//BufferedImage resizeImagePng = resizeImage(originalImage, type);	//chose one or another function...

		BufferedImage resizeImagePng =resizeImageWithHint(originalImage, type);
		ImageIO.write(resizeImagePng, "png", new File(path+img));
	}catch(IOException e){
		System.out.println(e.getMessage());
	}
    }

	/**
	 * Simple resize. I never use this
	 *
	 * @param originalImage the original image
	 * @param type the type
	 * @return the buffered image
	 */
    @SuppressWarnings("unused")
	private static BufferedImage resizeImage(BufferedImage originalImage, int type){
	BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
	Graphics2D g = resizedImage.createGraphics();
	g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
	g.dispose();

	return resizedImage;
    }

    /**
     * Alternative better resize.
     *
     * @param originalImage the original image
     * @param type the type
     * @return the buffered image
     */
    private static BufferedImage resizeImageWithHint(BufferedImage originalImage, int type){

	BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
	Graphics2D g = resizedImage.createGraphics();
	g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
	g.dispose();
	g.setComposite(AlphaComposite.Src);

	g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	g.setRenderingHint(RenderingHints.KEY_RENDERING,
	RenderingHints.VALUE_RENDER_QUALITY);
	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	RenderingHints.VALUE_ANTIALIAS_ON);

	return resizedImage;
    }
}