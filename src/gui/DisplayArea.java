package gui;

import api.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;


/**
 * User select information.This will be use to select a results generated.
 *
 * @author tyronsamaroo
 */
public class DisplayArea extends JPanel {

    private JLabel downloadLabel;
    private JButton downloadBtn;
    private DefaultTableModel table;
    JPanel panel = new JPanel();
    public SearchBar searchBar;
    private DefaultTableModel infoTable;


    private JTextField searchField;

    public DisplayArea() throws Exception {


        searchBar = new SearchBar();

        Dimension dim = getPreferredSize();
        System.out.println(dim);
        dim.width = 250;
        setPreferredSize(dim);


    }
}
