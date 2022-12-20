package Managers.GUI;

import spaceships.models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * SVERONIS SOTIRIOS 1092845
 * SOUKARAS GEORGIOS 1092660
 * */

public class SelectionPanel extends JPanel {

    private static SelectionPanel selectionPanelClass = null;
    private JPanel selectionPanel;
    private JPanel NPanel;
    private JPanel CPanel;

    public SelectionPanel(){
        super();
        this.selectionPanel = this;
        this.selectionPanel.setLayout(new BorderLayout(10, 10));
        this.selectionPanel.setBackground(Color.BLACK);

        this.NPanel = new JPanel();
        this.NPanel.setBackground(Color.BLACK);
        JLabel head = new JLabel("Please choose your Spaceship");
        head.setForeground(Color.WHITE);
        head.setFont(new Font("Arcade Classic", Font.PLAIN, 25));
        this.NPanel.add(head);
        this.selectionPanel.add(this.NPanel, BorderLayout.NORTH);

        this.CPanel = new JPanel();
        this.CPanel.setBackground(Color.BLACK);
        this.CPanel.setLayout(new GridLayout(1,5));

        JButton ALPHAbtn = new JButton();
        ALPHAbtn.setIcon(new ImageIcon(SpaceShipALPHA.getImage()));
        this.makeBtnTransparent(ALPHAbtn);
        this.onClickListener(ALPHAbtn, SpaceShips.ALPHA);
        this.CPanel.add(ALPHAbtn);

        JButton BETAbtn = new JButton();
        BETAbtn.setIcon(new ImageIcon(SpaceShipBETA.getImage()));
        this.makeBtnTransparent(BETAbtn);
        this.onClickListener(BETAbtn, SpaceShips.BETA);
        this.CPanel.add(BETAbtn);

        JButton DELTAbtn = new JButton();
        DELTAbtn.setIcon(new ImageIcon(SpaceShipDELTA.getImage()));
        this.makeBtnTransparent(DELTAbtn);
        this.onClickListener(DELTAbtn, SpaceShips.DELTA);
        this.CPanel.add(DELTAbtn);

        JButton GAMAbtn = new JButton();
        GAMAbtn.setIcon(new ImageIcon(SpaceShipGAMA.getImage()));
        this.makeBtnTransparent(GAMAbtn);
        this.onClickListener(GAMAbtn, SpaceShips.GAMA);
        this.CPanel.add(GAMAbtn);

        JButton ZERObtn = new JButton();
        ZERObtn.setIcon(new ImageIcon(SpaceShipZERO.getImage()));
        this.makeBtnTransparent(ZERObtn);
        this.onClickListener(ZERObtn, SpaceShips.ZERO);
        this.CPanel.add(ZERObtn);

        this.selectionPanel.add(this.CPanel, BorderLayout.CENTER);


        this.selectionPanel.setFocusable(true);
        this.selectionPanel.setVisible(true);
    }

    private void makeBtnTransparent(JButton button){
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }

    private void onClickListener(JButton btn, SpaceShips s){
        class BtnListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                SpaceFrame.play(s);
            }
        }

        btn.addActionListener(new BtnListener());
    }
}
