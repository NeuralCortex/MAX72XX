/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nc.max.controller;

import com.fx.swing.tools.LayoutFunctions;
import com.nc.max.Globals;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author pscha
 */
public class MaxController extends JPanel implements ActionListener {

    private final JFrame frame;
    private final ResourceBundle bundle;
    private JPanel jpGrid;
    private JButton jbGen;
    private JTextField jtfResult;

    private final int SIZE = 8;

    public MaxController(JFrame frame, ResourceBundle bundle) {
        this.frame = frame;
        this.bundle = bundle;
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jpGrid = new JPanel(new BorderLayout());
        jpGrid.setBackground(Globals.COLOR_BLUE);

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        int insets = 5;
        gridBagConstraints.insets = new Insets(insets, insets, insets, insets);
        jpGrid.setLayout(gridBagLayout);

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                gridBagConstraints.gridx = j;
                gridBagConstraints.gridy = i;
                
                JCheckBox jCheckBoxDot = new JCheckBox();
                jCheckBoxDot.addActionListener(this);
                jpGrid.add(jCheckBoxDot, gridBagConstraints);
            }
        }

        jpGrid.setLayout(gridBagLayout);

        add(jpGrid, BorderLayout.CENTER);

        jbGen = new JButton(bundle.getString("btn.gen"));
        jbGen.addActionListener(this);
        
        jtfResult=new JTextField();

        add(LayoutFunctions.createOptionPanelX(Globals.COLOR_INDIGO, jtfResult, jbGen), BorderLayout.SOUTH);

        frame.add(this);
    }

    private Component getComponentAtGrid(JPanel panel, int x, int y) {
        GridBagLayout layout = (GridBagLayout) panel.getLayout();

        for (Component comp : panel.getComponents()) {
            GridBagConstraints gbc = layout.getConstraints(comp);

            boolean inX = (gbc.gridx <= x && x < gbc.gridx + gbc.gridwidth);
            boolean inY = (gbc.gridy <= y && y < gbc.gridy + gbc.gridheight);

            if (inX && inY) {
                return comp;
            }
        }
        return null;
    }

    private String binStringToHex(String bin) {
        return "0x" + (new BigInteger(bin, 2).toString(16)).toLowerCase();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            String result = "byte arr[8] = {";
            for (int i = 0; i < SIZE; i++) {
                String b = "";
                for (int j = 0; j < SIZE; j++) {
                    JCheckBox jCheckBox = (JCheckBox) getComponentAtGrid(jpGrid, j, i);
                    b += jCheckBox.isSelected() ? "1" : "0";
                }
                b = binStringToHex(b);
                if (i < SIZE - 1) {
                    result += b + ", ";
                } else {
                    result += b;
                }
            }
            result = result + "};";
            jtfResult.setText(result);
        }
        
        if(e.getSource() instanceof JCheckBox){
            jtfResult.setText("");
        }
    }
}
