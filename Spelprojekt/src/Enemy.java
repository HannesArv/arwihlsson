
/**
 * Created by Hannes on 14/05/2017.
 */
public class Enemy extends Structure {
    private int dx;
    private int dy;

    private int enemySpeed;

    private int xLeft;
    private int xRight;
    private int yTop;
    private int yBottom;

    public Enemy(int x, int y, int speed){
        super(x, y);
        enemySpeed = speed;
        initEnemy();
    }

    private void initEnemy(){
        loadImage("Spelprojekt/src/images/enemyPig.png", 50, 50);
        image = super.getImage();
        getImageDim();

        dx = enemySpeed;
        dy = enemySpeed;

        xLeft = 0;
        xRight = 1630;
        yTop = 0;
        yBottom = 900;
    }

    public void move(){
        x += dx;
        y += dy;
        simpleMapBound(x, y);
    }

    private void simpleMapBound(int x, int y){
        if (y <= yTop){
            dy = enemySpeed;
        }
        if (y >= yBottom){
            dy = -enemySpeed;
        }
        if (x <= xLeft){
            dx = enemySpeed;
        }
        if (x >= xRight){
            dx = -enemySpeed;
        }
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
