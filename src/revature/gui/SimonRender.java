package revature.gui;

import revature.SimonSays;

import javax.swing.*;
import java.awt.*;

public class SimonRender extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (SimonSays.simon != null) {
            SimonSays.simon.paint((Graphics2D) g);
        }
    }
}
