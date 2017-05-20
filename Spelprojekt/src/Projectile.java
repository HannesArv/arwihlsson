
/**
 * Created by Konrad on 2017-05-17.
 * The class for projectiles which are fired by the player
 * (and possibly by others!)
 */
public class Projectile extends Structure {

    /**
     * A number which indicates where this projectile is headed.
     * A zero means it's stationary, 1 means up, 2 means up and
     * to the right, 3 means right and so on.
     */
    private int direction;

    public Projectile(int x, int y){
        super(x, y);
        initProjectile();
    }

    private void initProjectile(){
        loadImage("/images/proj.png", 10, 10);
        getImageDim();

        this.direction = 0;
        setVisible(false);

        xLeft = -10;
        xRight = 1700;
        yTop = -10;
        yBottom = 1000;
    }

    /**
     * Determines how the projectile should move, and detects if it has hit anything.
     */
    public void move(){
        dy = 0;
        dx = 0;
        switch (direction){
            case 0:
                return;
            case 1:
                if (!hit()){
                    dy = -3;
                }
                break;
            case 2:
                if (!hit()){
                    dx = 1;
                    dy = -1;
                }
                break;
            case 3:
                if (!hit()){
                    dx = 3;
                }
                break;
            case 4:
                if (!hit()){
                    dy = 1;
                    dx = 1;
                }
                break;
            case 5:
                if (!hit()){
                   dy = 3;
                }
                break;
            case 6:
                if (!hit()){
                    dy = 1;
                    dx = -1;
                }
                break;
            case 7:
                if (!hit()){
                    dx = -3;
                }
                break;
            case 8:
                if (!hit()){
                    dx = -1;
                    dy = 1;
                }
        }

        x += dx;
        y += dy;
    }

    /**
     * This method sets the direction of the projectile.
     * @param speed An int between 0 and 8.
     */
    public void setDirection(int speed){
        direction = speed;
    }

    public boolean hit(){
        return (x >= xRight) || (x <= xLeft) || (y >= yBottom) || (y <= yTop);
    }

    public void fire(int x, int y, int direction){
        this.x = x;
        this.y = y;
        setVisible(true);
        this.direction = direction;
    }

    /**
     * Makes the projectile invisible and stationary.
     */
    public void dissolve(){
        direction = 0;
        setVisible(false);
    }


}
