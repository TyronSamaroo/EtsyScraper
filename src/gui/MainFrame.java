package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {


    private SearchBar searchBar;

    public MainFrame(){

        searchBar = new SearchBar();


        setLayout(new BorderLayout());
        add(searchBar,BorderLayout.NORTH);




        setSize(1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);



    }
}