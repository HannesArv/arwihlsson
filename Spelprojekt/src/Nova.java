import javax.swing.*;
import java.awt.*;

/**
 * Created by Konrad on 2017-04-30.
 */
public class Nova extends JFrame {

    public Nova(){
        initUI();
    }

    private void initUI(){

        add(new Window());
        setBackground(new Color(255,0,0));
        setSize(250, 250);
        setTitle("Nova");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Nova nova = new Nova();
                nova.setVisible(true);
            }
        });

    }



}
