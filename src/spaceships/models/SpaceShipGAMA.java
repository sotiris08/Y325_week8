package spaceships.models;

import spaceships.SpaceShip;
import spaceships.SpaceShipMovementSteps;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/*
 * SVERONIS SOTIRIOS 1092845
 * SOUKARAS GEORGIOS 1092660
 * */
public class SpaceShipGAMA extends SpaceShip implements SpaceShipImpementation {

    public SpaceShipGAMA(Color lazeColor){
        super(SpaceShipMovementSteps.PIXELS_30, lazeColor);
        super.SpaceShipImageIcon = SpaceShipGAMA.getImage();
    }

    public static Image getImage(){
        try {
            return ImageIO.read(SpaceShipGAMA.class.getResource("./images/GAMA.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void printLocation() {
        System.out.println("SpaceShipGAMA is at (" + super.getxCords() + ", " + super.getyCords() + ").");
    }
}
