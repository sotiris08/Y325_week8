package Managers.GUI;

import spaceships.models.SpaceShips;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * SVERONIS SOTIRIOS 1092845
 * SOUKARAS GEORGIOS 1092660
 * */

public class SpaceFrame extends JFrame {

    public static JFrame frame = new JFrame("Space Invaders");;
    private static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    private SpaceFrame(){}

    public static void create(){
        SpaceFrame.frame.dispose();
        SpaceFrame.frame = new JFrame("Space Invaders");

        SpaceFrame.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        SpaceFrame.frame.setLocationRelativeTo(null);
        SpaceFrame.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        SpaceFrame.frame.add(new SelectionPanel());

        SpaceFrame.frame.setFocusable(true);
        SpaceFrame.frame.requestFocus();
        SpaceFrame.frame.pack();
        SpaceFrame.frame.setVisible(true);

        try {
            SpaceFrame.playSound();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public static void play(SpaceShips s){
        SpaceFrame.frame.dispose();
        SpaceFrame.frame = new JFrame("Space Invaders");

        SpaceFrame.frame.add(new GamePanel(s));

        SpaceFrame.frame.setUndecorated(false);
        SpaceFrame.frame.setResizable(false);

        device.setFullScreenWindow(SpaceFrame.frame);
    }

    public static void gameOver(String s){
        SpaceFrame.frame.dispose();
        SpaceFrame.frame = new JFrame("Space Invaders");

        SpaceFrame.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        SpaceFrame.frame.setLocationRelativeTo(null);
        SpaceFrame.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        SpaceFrame.frame.add(new GameOver(s));

        SpaceFrame.frame.setFocusable(true);
        SpaceFrame.frame.requestFocus();
        SpaceFrame.frame.pack();
        SpaceFrame.frame.setVisible(true);
    }

    private static void playSound() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        URL file = new URL("file:src/Managers/GUI/media/space-ambience.wav");
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(ais);
        clip.setFramePosition(0);
        clip.start();
    }
}
