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
public class SpaceShipBETA extends SpaceShip implements SpaceShipImpementation {

    public SpaceShipBETA(Color lazeColor){
        super(SpaceShipMovementSteps.PIXELS_20, lazeColor);
        super.SpaceShipImageIcon = SpaceShipBETA.getImage();
    }

    public static Image getImage(){
        try {
            return ImageIO.read(SpaceShipBETA.class.getResource("./images/BETA.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void printLocation() {
        System.out.println("SpaceShipBETA is at (" + super.getxCords() + ", " + super.getyCords() + ").");
    }
}
