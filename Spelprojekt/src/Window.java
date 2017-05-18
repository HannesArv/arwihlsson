import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Konrad on 2017-05-08.
 */

public class Window extends JPanel implements ActionListener {
    private Timer timer;
    private Character character;
    private ArrayList<Enemy> enemies;
    private Projectile ammo;
    private GameOver end;
    private GameOver endBad;
    private boolean gameOver;
    private boolean gameOverBad;
    private final int DELAY = 10;

    public Window() {
        initWindow();
    }

    private void initWindow() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setDoubleBuffered(true);
        setOpaque(false);

        gameOver = false;

        character = new Character(50, 50);
        initEnemies();

        end = new GameOver(0, 0, "Spelprojekt/src/images/winner.png");
        endBad = new GameOver(0,0,"Spelprojekt/src/images/endgame.png");

        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void initEnemies() {
        enemies = new ArrayList<>();
        enemies.add(new Enemy(180, 30, 2));
        enemies.add(new Enemy(300, 700, 1));
        enemies.add(new Enemy(750, 300, 3));
        enemies.add(new Enemy(1300, 300, 1));
        enemies.add(new Enemy(100, 500, 2));
        enemies.add(new Enemy(1500, 300, 1));
        enemies.add(new Enemy(1100, 800, 2));
        enemies.add(new Enemy(650, 600, 3));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (character.isVisible()) {
            g2d.drawImage(character.getImage(), character.getX(), character.getY(), this);
        }
        for (Enemy enemy : enemies) {
            if (enemy.isVisible()) {
                g2d.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
            }
        }

        ArrayList<Projectile> projectiles = character.returnProjectile();
        for (Projectile projectile : projectiles) {
            if (projectile.isVisible()) {
                ammo = projectile;
                g2d.drawImage(ammo.getImage(), ammo.getX(), ammo.getY(), this);
            }

        }
        if (gameOverBad){
            g2d.drawImage(endBad.getImage(), endBad.getX(), endBad.getY(), this);
        }
        if (gameOver) {
            g2d.drawImage(end.getImage(), end.getX(), end.getY(), this);
        }
    }

    @Override
    public void actionPerformed (ActionEvent e){
        character.move();
        updateEnemies();
        updateProjectile();
        collision();
        repaint();
    }


    private void updateProjectile() {
        ArrayList<Projectile> projectiles = character.returnProjectile();
        for (int i = 0; i < projectiles.size(); i++){
            Projectile projectile = projectiles.get(i);
            if (projectile.isVisible()){
                ammo = projectile;
                ammo.move();
            } else {
                projectiles.remove(i);
            }
        }
    }

    private void updateEnemies() {
        if (enemies.isEmpty()){
            gameOver();
            return;
        }
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if (enemy.isVisible()) {
                enemy.move();
            } else {
                enemies.remove(i);
            }
        }
    }


    private void collision() {
        Rectangle charR = character.getBounds();
        for (Enemy enemy : enemies) {
            Rectangle enemyR = enemy.getBounds();
            if (charR.intersects(enemyR)) {
                character.setVisible(false);
                enemy.setVisible(false);
                gameOverBad();
            }
        }
        ArrayList<Projectile> projectiles = character.returnProjectile();
        for (Projectile projectile : projectiles) {
            Rectangle projectileR = projectile.getBounds();
            for (Enemy enemy : enemies) {
                Rectangle enemyR = enemy.getBounds();
                if (projectileR.intersects(enemyR)) {
                    projectile.setVisible(false);
                    enemy.setVisible(false);
                    kill();
                }
            }
        }
    }

    private void kill(){
        int i = 0;
        for (Enemy enemy : enemies){
            if (!enemy.isVisible()){
                i+=1;
            }
        }
        if (i > enemies.size()+1){
            gameOver();
        }
    }

    private void gameOver() {
        gameOver = true;
        timer.stop();
    }

    private void gameOverBad(){
        gameOverBad = true;
        timer.stop();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            character.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            character.keyPressed(e);
        }
    }
}

