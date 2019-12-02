package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.concurrent.Flow;

/**
 * User select information.This will be use to select a results generated.
 *
 * @author tyronsamaroo
 */
public class FormPanel extends JPanel {

    private JLabel downloadLabel;
    private JButton downloadBtn;

    private JTextField searchField;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        System.out.println(dim);
        dim.width = 250;
        setPreferredSize(dim);

        downloadLabel = new JLabel("Download Image");
        downloadBtn = new JButton("Download");



        Border innerBorder = BorderFactory.createTitledBorder("User Input");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();


        ///// First ROW /////////////
        gc.weightx = 1;
        gc.weighty = 0.1;
        //Important needed
        gc.gridx = 0;
        gc.gridy = 0;
//        gc.weightx = 1;
//        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(downloadLabel, gc);


        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(downloadBtn, gc);


    }
}
