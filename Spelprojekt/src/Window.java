import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Konrad on 2017-05-08.
 */

public class Window extends JPanel implements ActionListener {
    private Timer timer;
    private Character character;
    private Enemy enemy;
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
        enemy = new Enemy(50, 50);

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
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(character.getImage(), character.getX(), character.getY(), this);
        g2d.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);

        ArrayList<Projectile> projectiles = character.returnProjectile();
        for (Projectile p : projectiles){
            ammo = p;
            g2d.drawImage(ammo.getImage(), ammo.getX(), ammo.getY(), this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        character.move();
        enemy.move();
        updateProjectile();
        repaint();
    }

    private class TAdapter extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent e){
            character.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e){
            character.keyPressed(e);
        }
    }

    public void updateProjectile(){
        ArrayList<Projectile> projectiles = character.returnProjectile();
        for (int i = 0; i < projectiles.size(); i++){
            ammo = projectiles.get(i);
            ammo.move();
        }
    }
}
