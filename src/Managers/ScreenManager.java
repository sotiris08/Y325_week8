package Managers;

import javax.swing.*;
import java.awt.*;

/*
 * SVERONIS SOTIRIOS 1092845
 * SOUKARAS GEORGIOS 1092660
 * */
public class ScreenManager extends JFrame {
    static private int ScreenWidth = 0;
    static private int ScreenHeight = 0;

    static private int ImageHeight = 100;
    static private int ImageWidth = 100;

    private ScreenManager(){}

    public static void getScreenDimensions(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        ScreenManager.ScreenHeight = (int) dimension.getHeight();
        ScreenManager.ScreenWidth = (int) dimension.getWidth();
    }

    public static int getScreenWidth(){
        if (ScreenManager.ScreenWidth == 0) ScreenManager.getScreenDimensions();
        return ScreenManager.ScreenWidth;
    }

    public static int getScreenHeight(){
        if (ScreenManager.ScreenHeight == 0) ScreenManager.getScreenDimensions();
        return ScreenManager.ScreenHeight;
    }

    public static int getImageHeight(){
        return ScreenManager.ImageHeight;
    }

    public static int getImageWidth(){
        return ScreenManager.ImageWidth;
    }

    public static boolean isInsideScreen(int x, int y){
        if(x <= ScreenManager.getScreenWidth() && x >= 0 && y <= ScreenManager.getScreenHeight() && y >= 0) return true;
        else return false;
    }
}
