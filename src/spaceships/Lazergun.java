package spaceships;

import spaceships.models.SpaceShips;

import java.awt.*;
import java.util.LinkedList;

public class Lazergun {
    public Color lazerColor;
    public LinkedList<Lazer> lazerShootersLinkedList = new LinkedList<Lazer>();

    public Lazergun(Color lazerColor){
        this.lazerColor = lazerColor;
    }

    public void fire (int x, int y, int step, SpaceShips spaceShips){
        lazerShootersLinkedList.add(lazerShootersLinkedList.size(), new Lazer(x+50, y, step, spaceShips));
    }
}
