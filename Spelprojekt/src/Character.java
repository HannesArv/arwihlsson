import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Created by Hannes on 11/05/2017.
 */
public class Character {
    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;

    public Character(){
        initChar();
    }

    private void initChar(){
        try {
            BufferedImage temp = ImageIO.read(new File("Spelprojekt/src/images/kamraten.png"));
            image = temp.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        }
        catch (IOException e){
            System.out.println("Couldn't find an image");
        }
        x = 50;
        y = 50;
    }

    public void move(){
        x += dx;
        y += dy;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Image getImage(){
        return image;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT){
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT){
            dx = 1;
        }

        if (key == KeyEvent.VK_UP){
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN){
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT){
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT){
            dx = 0;
        }

        if (key == KeyEvent.VK_UP){
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN){
            dy = 0;
        }
    }
}
