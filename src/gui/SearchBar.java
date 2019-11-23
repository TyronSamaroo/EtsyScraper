package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBar extends JPanel implements ActionListener {

    private JLabel searchLabel;
    private JTextField searchField;
    private JButton searchButton;

    public JTextField getSearchField() {
        return searchField;
    }

    public void setSearchField(JTextField searchField) {
        this.searchField = searchField;
    }

    public SearchBar(){
        setBorder(BorderFactory.createEtchedBorder());


        searchLabel = new JLabel("Search Here");
        searchLabel.setFont(new Font("", Font.PLAIN, 20));
        searchField = new JTextField(30);
        searchField.setFont(new Font("", Font.PLAIN, 20));
        searchButton = new JButton("Submit");
        searchButton.setFont(new Font("", Font.PLAIN, 20));

        searchButton.addActionListener(this);


        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(searchLabel);
        add(searchField);
        add(searchButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(searchField.getText());
        String result = searchField.getText();


    }
}
