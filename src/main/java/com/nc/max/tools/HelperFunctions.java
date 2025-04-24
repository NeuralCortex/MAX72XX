package com.nc.max.tools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

public class HelperFunctions {

    public static void centerWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        double x = (dimension.getWidth() - frame.getWidth()) / 2.0;
        double y = (dimension.getHeight() - frame.getHeight()) / 2.0;
        frame.setLocation((int) x, (int) y);
    }
    
     public static Color getColorFromHex(String hex) {
        int r = Integer.valueOf(hex.substring(1, 3), 16);
        int g = Integer.valueOf(hex.substring(3, 5), 16);
        int b = Integer.valueOf(hex.substring(5, 7), 16);

        return new Color(r, g, b);
    }
}