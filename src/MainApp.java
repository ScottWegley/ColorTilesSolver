package src;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class MainApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Tiles Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,300);

        JPanel panel = new JPanel();

        JLabel pLabel = new JLabel("Top Left: " + " | Bottom Right: ");
        panel.add(pLabel);

        JButton regionButton = new JButton("Select Game Region");
        regionButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setState(JFrame.ICONIFIED);
            }
            
        });

        frame.getContentPane().add(BorderLayout.SOUTH,panel);
        frame.setVisible(true);

    }
}