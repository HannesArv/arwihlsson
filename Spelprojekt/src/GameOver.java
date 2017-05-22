/**
 * Created by Hannes on 18/05/2017.
 */
public class GameOver extends Structure {

    public GameOver(int x, int y, String endGame){
        super(x,y);
        loadImage(endGame, 1000, 700);
        image = super.getImage();
    }
}
