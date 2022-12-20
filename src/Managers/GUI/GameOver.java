package Managers.GUI;

import spaceships.models.SpaceShips;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver extends JPanel {
    private JPanel NPanel, CPanel, SPanel;
    public GameOver(String msg){
        super();
        this.setLayout(new BorderLayout(10, 10));
        this.setBackground(Color.BLACK);

        this.NPanel = new JPanel();
        this.NPanel.setBackground(Color.BLACK);
        JLabel GO = new JLabel("Game Over");
        GO.setForeground(Color.WHITE);
        GO.setFont(new Font("Arcade Classic", Font.BOLD, 35));
        this.NPanel.add(GO);
        this.add(this.NPanel, BorderLayout.NORTH);

        this.CPanel = new JPanel();
        this.CPanel.setBackground(Color.BLACK);
        JLabel label = new JLabel(msg);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arcade Classic", Font.PLAIN, 25));
        this.CPanel.add(label);
        this.add(this.CPanel, BorderLayout.CENTER);

        this.SPanel = new JPanel();
        this.SPanel.setBackground(Color.BLACK);
        JButton playAgain = new JButton("Play Again");
        playAgain.setOpaque(true);
        playAgain.setContentAreaFilled(true);
        playAgain.setBorderPainted(false);
        this.onClickListener(playAgain);
        this.SPanel.add(playAgain);
        this.add(this.SPanel, BorderLayout.SOUTH);
    }

    private void onClickListener(JButton btn){
        class BtnListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                SpaceFrame.create();
            }
        }

        btn.addActionListener(new BtnListener());
    }
}
