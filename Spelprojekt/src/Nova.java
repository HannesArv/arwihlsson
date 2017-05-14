import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Konrad on 2017-04-30.
 */
public class Nova extends JFrame{

    public Nova(){
        initUI();
    }

    private void initUI(){

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
        backgroundPanel.add(new Window());
        backgroundPanel.add(new Background());

        add(backgroundPanel);
        setSize(1700, 900);
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
