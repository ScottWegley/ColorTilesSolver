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

    static int TLX, TLY, BRX, BRY;

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

    private static void takeScreenshot(String name) throws Exception {
        Robot r = new Robot();

        String path = "C:\\Code\\ColorTilesSolver\\src\\" + name + ".jpg";
        Rectangle capture = new Rectangle(TLX, TLY, BRX - TLX, BRY - TLY);
        BufferedImage Image = r.createScreenCapture(capture);
        ImageIO.write(Image, "jpg", new File(path));
    }

    public static int[][][] takeScreenshot() throws Exception {
        Robot r = new Robot();

        Rectangle capture = new Rectangle(TLX, TLY, BRX - TLX, BRY - TLY);
        BufferedImage Image = r.createScreenCapture(capture);
        return bi2int(Image);
    }

    public static int[][][] bi2int(BufferedImage bi) {
        int intimg[][][] = new int[3][bi.getHeight()][bi.getWidth()];
        for (int y = 0; y < bi.getHeight(); ++y) {
            for (int x = 0; x < bi.getWidth(); ++x) {
                int argb = bi.getRGB(x, y);
                intimg[0][y][x] = (argb >> 16) & 0xFF; // -- RED
                intimg[1][y][x] = (argb >> 8) & 0xFF; // -- GREEN
                intimg[2][y][x] = (argb >> 0) & 0xFF; // -- BLUE
            }
        }
        return intimg;
    }

    public static BufferedImage int2bi(int[][][] intimg) {
        BufferedImage bi = new BufferedImage(intimg[0][0].length, intimg[0].length, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < bi.getHeight(); ++y) {
            for (int x = 0; x < bi.getWidth(); ++x) {
                int rgb = (intimg[0][y][x] << 16) |
                        (intimg[1][y][x] << 8) |
                        (intimg[2][y][x] << 0);
                bi.setRGB(x, y, rgb);
            }
        }
        return bi;
    }
}
