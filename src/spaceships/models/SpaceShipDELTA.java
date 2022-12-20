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
public class SpaceShipDELTA extends SpaceShip implements SpaceShipImpementation {

    public SpaceShipDELTA(Color lazeColor){
        super(SpaceShipMovementSteps.PIXELS_40, lazeColor);
        super.SpaceShipImageIcon = SpaceShipDELTA.getImage();
    }

    public static Image getImage(){
        try {
            return ImageIO.read(SpaceShipDELTA.class.getResource("./images/DELTA.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void printLocation() {
        System.out.println("SpaceShipDELTA is at (" + super.getxCords() + ", " + super.getyCords() + ").");
    }
}
