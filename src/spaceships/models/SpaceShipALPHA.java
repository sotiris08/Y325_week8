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
public class SpaceShipALPHA extends SpaceShip implements SpaceShipImpementation {

    public SpaceShipALPHA(Color lazeColor){
        super(SpaceShipMovementSteps.PIXELS_10, lazeColor);
        super.SpaceShipImageIcon = SpaceShipALPHA.getImage();
    }

    public static Image getImage(){
        try {
            return ImageIO.read(SpaceShipALPHA.class.getResource("./images/ALPHA.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void printLocation() {
        System.out.println("SpaceShipALPHA is at (" + super.getxCords() + ", " + super.getyCords() + ").");
    }
}
