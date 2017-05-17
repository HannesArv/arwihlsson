import java.awt.*;

/**
 * Created by Hannes on 14/05/2017.
 */
public class Enemy extends Structure{
    private int dx;
    private int dy;
    private Image image;

    private int enemySpeed;

    private int xLeft;
    private int xRight;
    private int yTop;
    private int yBottom;

    public Enemy(int x, int y){
        super(x, y);
        initEnemy();
    }

    private void initEnemy(){
        loadImage("Spelprojekt/src/images/enemyPig.png", 50, 50);
        image = super.getImage();

        enemySpeed = 1;
        dx = enemySpeed;
        dy = 0;

        xLeft = 0;
        xRight = 950;
        yTop = 0;
        yBottom = 650;
    }

    public void move(){
        x += dx;
        y += dy;
        mapBound(x, y);
    }

    private void mapBound(int x, int y){
        if (y <= yTop && dx == enemySpeed){
            if (x >= xRight){
                dx = 0;
                dy = enemySpeed;
            }
        }
        if (x >= xRight && dy == -enemySpeed){
            if (y <= yTop){
                dx = -enemySpeed;
                dy = 0;
            }
        }
        if (x >= xRight && dx == enemySpeed){
            dx = 0;
            dy = enemySpeed;
        }
        if (y >= yBottom && dy == enemySpeed){
            dy = -enemySpeed;
        }
        if (x <= xLeft && dx == -enemySpeed){
            dx = enemySpeed;
        }
    }

}
