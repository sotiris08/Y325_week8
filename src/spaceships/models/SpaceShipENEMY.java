package spaceships.models;

import spaceships.SpaceShip;
import spaceships.SpaceShipMovementSteps;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * SVERONIS SOTIRIOS 1092845
 * SOUKARAS GEORGIOS 1092660
 * */
public class SpaceShipENEMY extends SpaceShip implements SpaceShipImpementation {

    public static int FIRING_PERIOD = 3000;

    public SpaceShipENEMY(Color lazeColor){
        super(SpaceShipMovementSteps.PIXELS_15, lazeColor);
        super.SpaceShipImageIcon = SpaceShipENEMY.getImage();
        super.setyCords(40);

        Runnable helloRunnable = new Runnable() {
            public void run() {
                fire(getxCords(), getyCords(), SpaceShipMovementSteps.PIXELS_15, SpaceShips.ENEMY);
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, SpaceShipENEMY.FIRING_PERIOD, TimeUnit.MILLISECONDS);
    }

    public static Image getImage(){
        try {
            return ImageIO.read(SpaceShipENEMY.class.getResource("./images/ENEMY.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void printLocation() {
        System.out.println("SpaceShipENEMY is at (" + super.getxCords() + ", " + super.getyCords() + ").");
    }

    public void nextPos(){
        this.moveRight();
    }
}
