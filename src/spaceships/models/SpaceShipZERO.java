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
public class SpaceShipZERO extends SpaceShip implements SpaceShipImpementation {

    public SpaceShipZERO(Color lazeColor){
        super(SpaceShipMovementSteps.PIXELS_5, lazeColor);
        super.SpaceShipImageIcon = SpaceShipZERO.getImage();
    }

    public static Image getImage(){
        try {
            return ImageIO.read(SpaceShipZERO.class.getResource("./images/ZERO.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void printLocation() {
        System.out.println("SpaceShipZERO is at (" + super.getxCords() + ", " + super.getyCords() + ").");
    }
}
