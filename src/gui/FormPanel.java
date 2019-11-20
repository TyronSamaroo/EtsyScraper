package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.concurrent.Flow;

public class FormPanel extends JPanel {

    private JLabel searchLabel;
    private JTextField searchField;

    public FormPanel(){


        Border innerBorder = BorderFactory.createTitledBorder("User Input");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(searchLabel);

    }
}
