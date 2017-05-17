import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * Created by Konrad on 2017-05-08.
 */

public class Window extends JPanel implements ActionListener{
    private Timer timer;
    private Character character;
    private Projectile ammo;
    private final int DELAY = 10;

    public Window(){
        initWindow();
    }

    private void initWindow(){
        addKeyListener(new TAdapter());
        setFocusable(true);
        setDoubleBuffered(true);
        setOpaque(false);

        character = new Character(50, 50);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void draw(Graphics g){
        Projectile p = character.returnProjectile();

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(character.getImage(), character.getX(), character.getY(), this);
        g2d.drawImage(p.getImage(), p.getX(), p.getY(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        character.move();
        repaint();
        updateProjectile().move();
    }

    private class TAdapter extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent e) {
            character.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            character.keyPressed(e);
        }
    }

    public Projectile updateProjectile() {
        return character.returnProjectile();
    }
}
