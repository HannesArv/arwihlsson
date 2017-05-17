import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Superclass for objects placed in the rooms of the game.
 * A structure has a position, and that's pretty much it.
 */
public class Structure {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean visible;
    protected Image image;

    protected int xLeft;
    protected int xRight;
    protected int yTop;
    protected int yBottom;

    protected int dx;
    protected int dy;

    public Structure(int x, int y){
        this.x = x;
        this.y = y;
        visible = true;
    }

    protected void getImageDim(){
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }

    protected void loadImage(String imageSource, int scaleWidth, int scaleHeight){
        try {
            BufferedImage temp = ImageIO.read(new URL(imageSource));
            image = temp.getScaledInstance(scaleWidth, scaleHeight, Image.SCALE_DEFAULT);
        }catch (IOException e){
            System.err.println("Couldn't find an image");
        }
    }

    public Image getImage(){
        return image;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean isVisible(){
        return visible;
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }
}