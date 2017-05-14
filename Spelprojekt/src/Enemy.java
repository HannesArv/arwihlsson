import java.awt.*;

/**
 * Created by Hannes on 14/05/2017.
 */
public class Enemy extends Structure{
    private int x;
    private int y;
    private int dx;
    private int dy;
    private Image image;

    private int xLeft;
    private int xRight;
    private int yTop;
    private int yBottom;

    public Enemy(int x, int y){
        super(x, y);
        dy = 1;
        dx = 1;
        initEnemy();
    }

    private void initEnemy(){
        loadImage("Spelprojekt/src/images/enemyPig.png", 50, 50);
        image = super.getImage();

        xLeft = 0;
        xRight = 950;
        yTop = 0;
        yBottom = 650;
    }

    public void move(){
        //while (true) {
            x += dx;
            //y += dy;
            //mapBound(x, y);

            //if (x <= xLeft){
            //    dx = 1;
            //}
            //if (x >= xRight){
            //    dx = -1;
            //}
            //if (y <= yTop){
            //    dy = 1;
            //}
            //if (y >= yBottom){
            //    dy = -1;
            //}
        //}
    }

    private void mapBound(int x, int y){
        if (x < xLeft) {
            x = xLeft;
        }
        if (x > xRight){
            x = xRight;
        }
        if (y < yTop){
            y = yTop;
        }
        if (y > yBottom){
            y = yBottom;
        }
    }

}
