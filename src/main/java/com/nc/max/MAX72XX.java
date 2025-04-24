/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.nc.max;

import com.nc.max.controller.MaxController;
import com.nc.max.themes.ThemeFX;
import com.nc.max.tools.HelperFunctions;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author pscha
 */
public class MAX72XX {

    private final ResourceBundle bundle = ResourceBundle.getBundle(Globals.BUNDLE_PATH, Globals.DEFAULT_LOCALE);

    public static void main(String[] args) {
        MAX72XX max7219 = new MAX72XX();
        max7219.init();
    }

    private void init() {
        ThemeFX.setup();
        try {
            UIManager.setLookAndFeel(new ThemeFX());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JFrame frame = new JFrame(bundle.getString("app.name") + " - " + bundle.getString("app.version"));
        frame.setIconImage(new ImageIcon(Globals.APP_LOGO_PATH).getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Globals.WIDTH, Globals.HEIGHT);

        new MaxController(frame, bundle);

        HelperFunctions.centerWindow(frame);

        if (Globals.DEBUG) {
            frame.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    System.out.println(frame.getWidth() + " " + frame.getHeight());
                }
            });
        }

        frame.setVisible(true);
    }
}
