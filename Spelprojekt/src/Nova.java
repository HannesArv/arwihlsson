import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Konrad on 2017-04-30.
 */
public class Nova extends JFrame {
    private static Image image;

    public Nova(){
        initUI();
    }

    private void initUI(){

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new OverlayLayout(gamePanel));
        gamePanel.add(new Window());
        gamePanel.add(new Background());

        add(gamePanel);
        setSize(1710, 1000);
        setTitle("Nova");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args){

        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                Nova nova = new Nova();
                try {
                    BufferedImage temp = ImageIO.read(new File("Spelprojekt/src/images/enemyPig.png"));
                    image = temp.getScaledInstance(10, 10, Image.SCALE_DEFAULT);
                }catch (IOException e){
                    System.err.println("Couldn't find an image");
                }
                nova.setIconImage(image);
                nova.setVisible(true);
            }
        });

    }
}
