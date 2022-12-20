package MainClass;

import Managers.GUI.SpaceFrame;
import Managers.ScreenManager;

/*
* SVERONIS SOTIRIOS 1092845
* SOUKARAS GEORGIOS 1092660
* */

public class MainClass {
    public static void main(String[] args){
        ScreenManager.getScreenDimensions();
        SpaceFrame.create();
    }
}
