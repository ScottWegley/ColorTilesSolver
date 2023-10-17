package src;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class WindowCollector {

    static JFrame parent;
    static JLabel pLabel;

    public static void getWindowCoordinates(JFrame pFrame, JLabel label) {
        parent = pFrame;
        pLabel = label;

        JOptionPane.showMessageDialog(null,
                "Please click once at the top left of the game region and once at the bottom right!");

        JFrame f = new JFrame("Glass Pane");
        JPanel glass = (JPanel) f.getGlassPane();


        glass.setVisible(true);
        f.setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
                (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        f.setUndecorated(true);
        f.setOpacity(0.10f);
        f.setVisible(true);
    }
}
