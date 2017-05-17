import java.awt.event.KeyListener;

/**
 * Created by Konrad on 2017-05-17.
 */
public class Projectile extends Structure {

    private int direction;

    public Projectile(int x, int y) {
        super(x, y);
        initProjectile();
    }

    private void initProjectile(){
        loadImage("Spelprojekt/src/images/kamraten.png", 10, 10);

        this.direction = 0;
        setVisible(false);

        xLeft = -10;
        xRight = 1000;
        yTop = -10;
        yBottom = 700;
    }

    public void move() {
        dy = 0;
        dx = 0;
        switch (direction) {
            case 0:
                return;
            case 1:
                if (!hit()) {
                    dy = -2;
                }
                break;
            case 2:
                if (!hit()) {
                    dx = 1;
                    dy = -1;
                }
                break;
            case 3:
                if (!hit()){
                    dx = 2;
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
                   dy = 2;
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
                    dx = -2;
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

    public void setDirection(int speed){
        direction = speed;
    }

    public boolean hit() {
        return (x >= xRight) || (x <= xLeft) || (y >= yBottom) || (y <= yTop);
    }

    public void fire(int x, int y, int direction){
        this.x = x;
        this.y = y;
        setVisible(true);
        this.direction = direction;
    }

    private void dissolve() {
        direction = 0;
        setVisible(false);
    }


}
