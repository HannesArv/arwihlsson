import java.awt.*;
import java.awt.event.KeyEvent;
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
        ImageIcon ii = new ImageIcon("Spelprojekt/src/images/character.png");
        image = ii.getImage();
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
