package spaceships;

import spaceships.models.SpaceShips;

public class Lazer {
    private int x;
    private int y;
    private int step;
    private SpaceShips spaceShips;

    public Lazer(int x, int y, int step, SpaceShips spaceShips){
        this.x = x;
        this.y = y;
        this.step = step;
        this.spaceShips = spaceShips;
    }

    public void nextPos(){
        if (this.spaceShips == SpaceShips.PLAYER){
            this.y = this.y - this.step;
        } else if (this.spaceShips == SpaceShips.ENEMY){
            this.y = this.y + this.step;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
