package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

/**
 * User select information.This will be use to select a results generated.
 *
 * @author tyronsamaroo
 */
public class FormPanel extends JPanel implements ActionListener {

    private JLabel downloadLabel;
    public JButton downloadBtn;

    private JTextField searchField;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        System.out.println(dim);
        dim.width = 600;
        setPreferredSize(dim);

        downloadBtn = new JButton("Download");

        ImageIcon resImage = new ImageIcon("data/image/1.jpg");
        downloadLabel = new JLabel(resImage);



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
        gc.insets = new Insets(0, 0, 0, 5);
        add(downloadLabel, gc);


        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(downloadBtn, gc);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Download");

    }


    public void setLabelImage(String imageName){
      ImageIcon resImage = new ImageIcon("data/image/"+ imageName + ".jpg");
      downloadLabel.setIcon(resImage);
    }
}
