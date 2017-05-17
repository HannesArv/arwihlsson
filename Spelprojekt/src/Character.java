import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Created by Hannes on 11/05/2017.
 */
public class Character extends Structure{
    private int dx;
    private int dy;
    private Image image;

    private int xLeft;
    private int xRight;
    private int yTop;
    private int yBottom;

    private int yDoorTop;
    private int yDoorBottom;
    private int xDoorLeft;
    private int xDoorRight;

    private ArrayList<Projectile> proj;

    public Character(int x, int y){
        super(x, y);
        initChar();
    }

    private void initChar(){
        proj = new ArrayList<>();

        loadImage("Spelprojekt/src/images/kamraten.png", 50, 50);
        image = super.getImage();

        xLeft = 0;
        xRight = 950;
        yTop = 0;
        yBottom = 650;

        yDoorTop = 280;
        yDoorBottom = 320;
        xDoorLeft = 430;
        xDoorRight = 470;
    }

    public void move(){
        x += dx;
        y += dy;

        mapBoundLeft(xLeft, xRight, yDoorTop, yDoorBottom);
        mapBoundRight(xLeft, xRight, yDoorTop, yDoorBottom);
        mapBoundBottom(yTop, yBottom, xDoorLeft, xDoorRight);
        mapBoundTop(yTop, yBottom, xDoorLeft, xDoorRight);
    }

    private void mapBoundLeft(int xLeft, int xRight, int yDoorTop, int yDoorBottom){
        if (x < xLeft && (y >= yDoorTop && y <= yDoorBottom)) {
            if (x < xLeft - 50) {
                x = xRight;
            }
            if (y < yDoorTop + 1) {
                y = yDoorTop + 1;
            }
            if (y > yDoorBottom - 1) {
                y = yDoorBottom - 1;
            }
        }
        else if (x < xLeft) {
            x = xLeft;
        }
    }

    private void mapBoundRight(int xLeft, int xRight, int yDoorTop, int yDoorBottom){
        if (x > xRight && (y >= yDoorTop && y <= yDoorBottom)) {
            if (x > xRight + 50) {
                x = xLeft;
            }
            if (y < yDoorTop + 1) {
                y = yDoorTop + 1;
            }
            if (y > yDoorBottom - 1) {
                y = yDoorBottom - 1;
            }
        }
        else if (x > xRight) {
            x = xRight;
        }
    }

    private void mapBoundTop(int yTop, int yBottom, int xDoorLeft, int xDoorRight){
        if (y < yTop && (x >= xDoorLeft && x <= xDoorRight)) {
            if (y < yTop - 50) {
                y = yBottom;

                int REMOVE = 0;
            }
            if (x < xDoorLeft + 1) {
                x = xDoorLeft + 1;
            }
            if (x > xDoorRight - 1) {
                x = xDoorRight - 1;
            }
        }
        else if (y < yTop) {
            y = yTop;
        }
    }

    private void mapBoundBottom(int yTop, int yBottom, int xDoorLeft, int xDoorRight){
        if (y > yBottom && (x >= xDoorLeft && x <= xDoorRight)) {
            if (y > yBottom + 50) {
                y = yTop;

                int REMOVE = 0;
            }
            if (x < xDoorLeft + 1) {
                x = xDoorLeft + 1;
            }
            if (x > xDoorRight - 1) {
                x = xDoorRight - 1;
            }
        }
        else if (y > yBottom) {
            y = yBottom;
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

    /**
     * Move the character and fire projectiles!
     */
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_A:  dx = -1;
                break;
            case KeyEvent.VK_D: dx = 1;
                break;
            case KeyEvent.VK_W:    dy = -1;
                break;
            case KeyEvent.VK_S:  dy = 1;
                break;
            case KeyEvent.VK_LEFT:  fireProjectile(x + 25, y + 25, 7);
                break;
            case KeyEvent.VK_RIGHT:  fireProjectile(x + 25, y + 25, 3);
                break;
            case KeyEvent.VK_DOWN:  fireProjectile(x + 25, y + 25, 5);
                break;
            case KeyEvent.VK_UP:  fireProjectile(x + 25, y + 25, 1);
                break;


        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_A:  dx = 0;
                break;
            case KeyEvent.VK_D:  dx = 0;
                break;
            case KeyEvent.VK_W:  dy = 0;
                break;
            case KeyEvent.VK_S:  dy = 0;
                break;
        }
    }

    public ArrayList returnProjectile(){
        return proj;
    }

    private void fireProjectile(int x, int y, int direction){
        Projectile projectile = null;
        proj.add(new Projectile(x, y));
        for (int i = 0; i < proj.size(); i++) {
            projectile = proj.get(i);
        }
        for (int i = 0; i < proj.size(); i++) {
            projectile.setDirection(direction);
        }
    }
}
