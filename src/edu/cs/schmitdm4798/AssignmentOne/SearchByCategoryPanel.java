package edu.cs.schmitdm4798.AssignmentOne;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Admin on 10/12/2016.
 */
public class SearchByCategoryPanel extends JPanel {

    private HenryDAO dao;

    public SearchByCategoryPanel(HenryDAO dao){
        this.dao = dao;
        Color color = new Color(46,125,50);
        JComboBox<String> comboBox = new JComboBox<>();
        this.add(comboBox);
        this.setBackground(color);
    }
}
