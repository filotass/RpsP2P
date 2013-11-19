/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author FFF
 */
public class Utils {
    
    public static void centralize(JFrame frame) {

        Dimension windowSize = frame.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int xPos = ((int) screenSize.getWidth() - (int) windowSize.getWidth()) / 2;
        int yPos = ((int) screenSize.getHeight() - (int) windowSize.getHeight()) / 2;
        frame.setLocation(xPos, yPos);
        frame.setVisible(true);
    }
}
