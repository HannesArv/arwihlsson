import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Hannes on 12/05/2017.
 */
public class Background extends JPanel {
    private ImageIcon image;

    public Background() {
        initBackground();
    }

    private void initBackground(){
        setFocusable(true);
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void draw(Graphics g){
        ImageIcon ii = new ImageIcon("Spelprojekt/src/images/bruteforcemap.png");
        Image image = ii.getImage();
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, 0, 0, this);

        //try {
        //    Image image = ImageIO.read(new File("Spelprojekt/src/images/bruteforcemap.png"));
        //    Graphics2D g2d = (Graphics2D) g;
        //    g2d.drawImage(image, 0, 0, this);
        //}
        //catch (IOException e){
        //    System.out.println("AAAAH");
        //}
    }

    public int getBackgroundWidth(){
        return image.getIconWidth();
    }

    public int getBackgroundHeight(){
        return image.getIconHeight();
    }
}
