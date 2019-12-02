package gui;

import javax.swing.*;
import java.awt.*;

/**
 * MainFrame used to connect all components of the gui together.
 *
 * @author tyronsamaroo
 */
public class MainFrame extends JFrame {


    private SearchBar searchBar;
    private FormPanel formPanel;
    private DisplayArea displayArea;

    public MainFrame() throws Exception {

        searchBar = new SearchBar();
        formPanel = new FormPanel();
        displayArea = new DisplayArea();


        setLayout(new BorderLayout());
        add(searchBar, BorderLayout.NORTH);
        add(formPanel, BorderLayout.WEST);
        add(displayArea,BorderLayout.CENTER);





        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }
}
