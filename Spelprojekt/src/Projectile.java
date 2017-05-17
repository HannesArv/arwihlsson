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
        loadImage("src/images/kamraten.png", 10, 10);

        this.direction = 1;
        setVisible(false);

        xLeft = 0;
        xRight = 950;
        yTop = 0;
        yBottom = 650;

        yDoorTop = 280;
        yDoorBottom = 320;
        xDoorLeft = 430;
        xDoorRight = 470;
    }

    public void move() {
        switch (direction) {
            case 0:
                return;
            case 1:
                if (!hit()) {
                    dy = 2;
                }
                break;
            case 2:
                if (!hit()) {
                    dx = 1;
                    dy = 1;
                }
                break;
            case 3:
                if (!hit()){
                    dx = 2;
                }
                break;
            case 4:
                if (!hit()){
                    dy = -1;
                    dx = 1;
                }
                break;
            case 5:
                if (!hit()){
                   dy = -2;
                }
                break;
            case 6:
                if (!hit()){
                    dy = -1;
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
    }

    public boolean hit() {
        if ((x >= xRight) || (x <= xLeft) || (y >= yTop) || (y <= yBottom)) {
            dissolve();
            return true;
        } else return false;
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
