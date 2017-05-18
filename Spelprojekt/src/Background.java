import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Hannes on 12/05/2017.
 */
public class Background extends JPanel {
    private Image image;
    private int backgroundWidth;
    private int backgroundHeight;

    public Background(){
        initBackground();
    }

    private void initBackground(){
        setFocusable(true);
        setDoubleBuffered(true);
        setBackground(Color.WHITE);

        backgroundWidth = 1700;
        backgroundHeight = 1000;

        grabImage();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, 0, 0, this);
    }

    private void grabImage(){
        try {
            BufferedImage temp = ImageIO.read(new URL("https://raw.githubusercontent.com/HannesArv/arwihlsson/master/Spelprojekt/src/images/bruteforcemap.png?token=AUrF0aunTHB10iZ7Aj-H4aIaMbwMZJcmks5ZJaktwA%3D%3D"));
            image = temp.getScaledInstance(backgroundWidth, backgroundHeight, Image.SCALE_DEFAULT);
        }
        catch (IOException e){
            System.err.println("Couldn't find an image");
        }
    }

    public int getBackgroundWidth(){
        return backgroundWidth;
    }

    public int getBackgroundHeight(){
        return backgroundHeight;
    }
}
