package edu.cs.schmitdm4798.AssignmentOne;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Admin on 10/12/2016.
 */
public class SearchByPublisherPanel extends JPanel {

    private HenryDAO dao;

    public SearchByPublisherPanel(HenryDAO dao) {
        this.dao = dao;
        Color color = new Color(255,110,64);
        JComboBox<String> comboBox = new JComboBox<>();
        this.add(comboBox);
        this.setBackground(color);
    }
}
