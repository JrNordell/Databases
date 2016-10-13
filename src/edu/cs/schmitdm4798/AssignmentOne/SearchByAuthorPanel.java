package edu.cs.schmitdm4798.AssignmentOne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Created by Admin on 10/12/2016.
 */
public class SearchByAuthorPanel extends JPanel {

    private HenryDAO dao;

    public  SearchByAuthorPanel(HenryDAO dao){
        this.dao = dao;
        Color color = new Color(63,81,181);

        JComboBox<String> comboBox = new JComboBox<String>(new Vector<String>(dao.getAuthorList()));
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox tempCombo = (JComboBox) e.getSource();
                String fullName = (String)tempCombo.getSelectedItem();
                fullName.split(" ");
                dao.getBookData();
            }
        });

        //test

        this.add(comboBox);
        this.setBackground(color);

    }
}
