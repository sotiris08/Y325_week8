package spaceships;

import Managers.ScreenManager;

import java.awt.*;

/*
 * SVERONIS SOTIRIOS 1092845
 * SOUKARAS GEORGIOS 1092660
 * */
public abstract class SpaceShip extends Lazergun implements Navigation {

    private int xCords;
    private int yCords;
    private int step;
    protected Image SpaceShipImageIcon;

    protected SpaceShip(int step, Color lazeColor) {
        super(lazeColor);
        this.xCords = 0;
        this.yCords = ScreenManager.getScreenHeight() - ScreenManager.getImageHeight() - 100;
        this.step = step;
    }

    public int getxCords(){
        return this.xCords;
    }

    public int getyCords(){
        return this.yCords;
    }

    public void setyCords(int y){
        this.yCords = y;
    }

    public int getStep(){
        return this.step;
    }

    public void moveSpaceShip(String input){
        switch (input){
            case "u":
                this.moveUP();
                break;
            case "d":
                this.moveDown();
                break;
            case "l":
                this.moveLeft();
                break;
            case "r":
                this.moveRight();
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid command");
                break;
        }

    }

    public Image getSpaceShipImageIcon(){
        return this.SpaceShipImageIcon;
    }

    @Override
    public int moveUP() {
        if (ScreenManager.isInsideScreen(this.xCords, (this.getyCords()) - step )) this.yCords -= step;
        else this.yCords = ScreenManager.getScreenHeight();
        return this.getyCords();
    }

    @Override
    public int moveDown() {
        if (ScreenManager.isInsideScreen(this.xCords, (this.getyCords()) + step )) this.yCords += step;
        else this.yCords = 0;
        return this.getyCords();
    }

    @Override
    public int moveRight() {
        if (ScreenManager.isInsideScreen((this.xCords) + step, this.yCords )) this.xCords += step;
        else this.xCords = 0;
        return this.getxCords();
    }

    @Override
    public int moveLeft() {
        if (ScreenManager.isInsideScreen((this.xCords) - step, this.yCords )) this.xCords -= step;
        else this.xCords = ScreenManager.getScreenWidth();
        return this.getxCords();
    }
}
