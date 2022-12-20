package Managers.GUI;

import Managers.KeyboardInput;
import Managers.ScreenManager;
import spaceships.Lazer;
import spaceships.SpaceShip;
import spaceships.models.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * SVERONIS SOTIRIOS 1092845
 * SOUKARAS GEORGIOS 1092660
 * */

public class GamePanel extends JPanel{

    private static long FIRING_COOLDOWN = 3000;
    private static long LAST_FIRE;
    private static boolean CAN_FIRE = true;
    public SpaceShip spaceShip;
    private SpaceShipENEMY enemy;
    private JLabel exitlabel = new JLabel("Press esc to exit.");

    private int userLifes = 3;
    private int botLifes = 3;

    public GamePanel(SpaceShips spaceShips){
        super();
        KeyboardInput keyboardInput = new KeyboardInput(this);
        this.setBackground(Color.BLACK);
        this.spaceShip = this.createSpeceShipInstance(spaceShips);
        this.enemy = new SpaceShipENEMY(Color.RED);
        this.addKeyListener(keyboardInput);

        Runnable helloRunnable = new Runnable() {
            public void run() {
                repaint();
            }
        };

        ScheduledExecutorService executor1 = Executors.newScheduledThreadPool(1);
        executor1.scheduleAtFixedRate(helloRunnable, 0, 100, TimeUnit.MILLISECONDS);

        /*Runnable firingCooldown = new Runnable() {
            @Override
            public void run() {
                CAN_FIRE = !CAN_FIRE;
            }
        };

        ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(1);
        executor2.scheduleAtFixedRate(firingCooldown, 0, FIRING_COOLDOWN, TimeUnit.MILLISECONDS);*/
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon img1 = new ImageIcon(spaceShip.getSpaceShipImageIcon());
        img1.paintIcon(this, g, this.spaceShip.getxCords(), this.spaceShip.getyCords());
        ImageIcon img2 = new ImageIcon(enemy.getSpaceShipImageIcon());
        img2.paintIcon(this, g, this.enemy.getxCords(), this.enemy.getyCords());
        paintHearts(g);
        enemy.nextPos();
        this.showLazerShootings(g);
        exitlabel.setForeground(Color.WHITE);
        exitlabel.setVisible(true);
        this.add(exitlabel);
        this.setVisible(true);
        this.setFocusable(true);
    }

    private void paintHearts(Graphics g){
        ImageIcon h,s = null;
        try {
            h = new ImageIcon(ImageIO.read(GamePanel.class.getResource("./media/heartsiconset.png")));
            s = new ImageIcon(ImageIO.read(GamePanel.class.getResource("./media/EPSILON.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < userLifes; i++) {
            h.paintIcon(this, g, 40*i+10, 10);
        }

        for (int i = 0; i < botLifes; i++) {
            s.paintIcon(this, g, ScreenManager.getScreenWidth() - ((50*(i+1))+(10*i)), 10);
        }
    }

    private void showLazerShootings(Graphics g){
        spaceShip.lazerShootersLinkedList.forEach((temp) -> {
            g.setColor(spaceShip.lazerColor);
            g.drawLine(temp.getX(), temp.getY(), temp.getX(), temp.getY()-15);
            temp.nextPos();
            if (temp.getY() < 0){
                spaceShip.lazerShootersLinkedList.remove(temp);
            }
            if (hasEnemyBeenHitted(temp)) spaceShip.lazerShootersLinkedList.remove(temp);
        });
        enemy.lazerShootersLinkedList.forEach((temp) -> {
            g.setColor(enemy.lazerColor);
            g.drawLine(temp.getX(), temp.getY(), temp.getX(), temp.getY()+15);
            temp.nextPos();
            if (temp.getY() < 0){
                enemy.lazerShootersLinkedList.remove(temp);
            }
            if (hasPlayerBeenHitted(temp)) enemy.lazerShootersLinkedList.remove(temp);
        });
    }

    private boolean hasEnemyBeenHitted(Lazer lazer){
        if ((lazer.getY() > enemy.getyCords() && lazer.getY() < enemy.getyCords()+100) && (lazer.getX() < enemy.getxCords()+100 && lazer.getX() > enemy.getxCords())){
            System.out.println("Enemy hitted");
            if (botLifes == 0){
                if (SpaceShipENEMY.FIRING_PERIOD > 600){
                    SpaceShipENEMY.FIRING_PERIOD -= 500;
                    GamePanel.FIRING_COOLDOWN += 500;
                }
                SpaceFrame.gameOver("You Won");
            }
            botLifes--;
            return true;
        } else {
            return false;
        }
    }

    private boolean hasPlayerBeenHitted(Lazer lazer){
        if ((lazer.getY() > spaceShip.getyCords() && lazer.getY() < spaceShip.getyCords()+100) && (lazer.getX() < spaceShip.getxCords()+100 && lazer.getX() > spaceShip.getxCords())){
            System.out.println("Player hitted");
            if (userLifes == 0){
                if (GamePanel.FIRING_COOLDOWN > 600){
                    SpaceShipENEMY.FIRING_PERIOD += 500;
                    GamePanel.FIRING_COOLDOWN -= 500;
                }
                SpaceFrame.gameOver("You Lost");
            }
            userLifes--;
            return true;
        } else {
            return false;
        }
    }

    private SpaceShip createSpeceShipInstance(SpaceShips s){
        switch (s){
            case ALPHA:
                return new SpaceShipALPHA(Color.BLUE);
            case BETA:
                return new SpaceShipBETA(Color.GREEN);
            case DELTA:
                return new SpaceShipDELTA(Color.YELLOW);
            case GAMA:
                return new SpaceShipGAMA(Color.CYAN);
            case ZERO:
                return new SpaceShipZERO(Color.MAGENTA);
        }
        return null;
    }

    public static boolean canFire(){
        if (GamePanel.CAN_FIRE) {
            GamePanel.LAST_FIRE = System.currentTimeMillis();
            GamePanel.CAN_FIRE = false;
            return true;
        }
        else if (System.currentTimeMillis() - GamePanel.LAST_FIRE > GamePanel.FIRING_COOLDOWN){
            GamePanel.LAST_FIRE = System.currentTimeMillis();
            return true;
        } else return false;
    }
}
