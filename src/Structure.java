/**
 * Superclass for objects placed in the rooms of the game.
 * A structure has a position, and that's pretty much it.
 */
public class Structure {

    protected int[] position;

    public Structure(int xPos, int yPos){

        position = new int[3];
        setPosition(xPos, yPos);

    }

    public void setPosition(int xPos, int yPos){
        position[0] = xPos;
        position[1] = yPos;
    }
    
    public int[] getPosition(){
        return position;
    }

}
