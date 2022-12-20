package Managers;

import Managers.GUI.GamePanel;
import spaceships.SpaceShipMovementSteps;
import spaceships.models.SpaceShips;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * SVERONIS SOTIRIOS 1092845
 * SOUKARAS GEORGIOS 1092660
 * */
public class KeyboardInput implements KeyListener {

    private GamePanel gamePanel;
    public KeyboardInput(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyCode());
        switch (e.getKeyCode()) {
            case (KeyEvent.VK_W) -> this.gamePanel.spaceShip.moveUP();
            case (KeyEvent.VK_S) -> this.gamePanel.spaceShip.moveDown();
            case (KeyEvent.VK_A) -> this.gamePanel.spaceShip.moveLeft();
            case (KeyEvent.VK_D) -> this.gamePanel.spaceShip.moveRight();
            case (KeyEvent.VK_SPACE) -> {
                if (GamePanel.canFire()){
                    this.gamePanel.spaceShip.fire(this.gamePanel.spaceShip.getxCords(), this.gamePanel.spaceShip.getyCords(), this.gamePanel.spaceShip.getStep(), SpaceShips.PLAYER);
                }
            }
            case (KeyEvent.VK_ESCAPE) -> System.exit(0);
        }
        this.gamePanel.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println(e.getKeyCode());
    }
}
