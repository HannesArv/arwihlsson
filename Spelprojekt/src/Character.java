import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 * Created by Hannes on 11/05/2017.
 */
public class Character extends Structure{
    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;

    public Character(int x, int y){
        super(x, y);
        initChar();
    }

    private void initChar(){
        loadImage("Spelprojekt/src/images/kamraten.png", 50, 50);
        image = super.getImage();
    }

    public void move(){
        x += dx;
        y += dy;

        if (x < 0) {
            x = 0;
        }

        if (y < 0) {
            y = 0;
        }
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
