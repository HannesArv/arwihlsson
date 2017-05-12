import javax.swing.*;
import java.awt.*;

/**
 * Created by Hannes on 12/05/2017.
 */
public class Background extends JPanel {
    private ImageIcon image;

    public Background() {
        initBackground();
    }

    private void initBackground(){
        setFocusable(true);
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void draw(Graphics g){
        image = new ImageIcon("Spelprojekt/src/images/bruteforcemap.png");
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image.getImage(), 0, 0, this);
    }

    public int getBackgroundWidth(){
        return image.getIconWidth();
    }

    public int getBackgroundHeight(){
        return image.getIconHeight();
    }
}
