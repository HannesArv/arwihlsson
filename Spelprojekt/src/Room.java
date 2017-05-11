import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;

/**
 * Created by Konrad on 2017-04-30.
 */
public class Room {

    /**
     * An arraylist containing the structures of this room.
     */
    private ArrayList<Structure> structures;

    public Room(){
        structures = new ArrayList<>();
    }

    /**
     * Adds a structure to this room.
     * @param s The structure to be added.
     */
    public void addStructure(Structure s){
        structures.add(s);
    }

    public void removeStructure(){
        //TODO
    }

}
