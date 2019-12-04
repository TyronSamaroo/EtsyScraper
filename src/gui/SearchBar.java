package gui;

import api.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;


/**
 * SearchBar is where the user input a search criteria for Etsy.
 *
 * @author tyronsamaroo
 */
public class SearchBar extends JPanel implements ActionListener {

    private JLabel            searchLabel;
    private JTextField        searchField;
    public  JButton           searchButton;
    public DefaultTableModel infoTable;
    public JTable            table;

    public JTextField getSearchField() {
        return searchField;
    }

    public void setSearchField(JTextField searchField) {
        this.searchField = searchField;
    }

    public SearchBar() {
        setBorder(BorderFactory.createEtchedBorder());


        searchLabel = new JLabel("Search Here");
        searchLabel.setFont(new Font("", Font.PLAIN, 20));
        searchField = new JTextField(30);
        searchField.setFont(new Font("", Font.PLAIN, 20));
        searchButton = new JButton("Submit");
        searchButton.setFont(new Font("", Font.PLAIN, 20));

        searchButton.addActionListener(this);

        String[] header = { "Description", "Price", "Link" };
        infoTable = new DefaultTableModel(header,0);
        table = new JTable(infoTable);


        JScrollPane pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(700, 500));

        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        add(searchLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        add(searchField);

        c.gridx = 2;
        c.gridy = 0;
        add(searchButton);

        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        add(pane, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {


            //System.out.println(searchField.getText());
            String result = searchField.getText();
            Etsy etsy = new Etsy(searchField.getText());
            WebpageReader webpageReader = new WebpageReader(etsy.getWebpage());
            EtsyCleanData data = new EtsyCleanData(webpageReader.rawHTMLFile());
            File f = new File("data/website/" + searchField.getText() + ".txt");
            System.out.println(f.getAbsolutePath());
            OutputData outputData = new OutputData(webpageReader.rawHTMLFile(), f);
            outputData.storeOutput();
            String stringToSplitPrice = data.cleanFileForPrice();
            String stringToSplitDescription = data.cleanFileForDescription();
            String stringToSplitImageSrc = data.cleanFileForImageSrc();

            String[] priceArray;
            String[] descriptionArray;
            String[] imageLinkArray;
            priceArray = stringToSplitPrice.split("\n");
            descriptionArray = stringToSplitDescription.split("\n");
            imageLinkArray = stringToSplitImageSrc.split("\n");
            StringBuilder results = new StringBuilder();
            ArrayList<ItemData> itemData = new ArrayList<>();
            for (int i = 0; i < priceArray.length; i++) {
                String price = priceArray[i];
                String description = descriptionArray[i];
                String image = imageLinkArray[i];
                ItemData item = new ItemData(description,price,image);
                itemData.add(item);
                results.append(item);

            }

            System.out.println("THIS IS");
            System.out.println(results);
            File ff = new File("data/results/" + searchField.getText() + ".txt");
            OutputData resfie = new OutputData(results,ff);
            resfie.storeOutput();

            infoTable.setRowCount(0);

            for(ItemData item: itemData){
                Object[][] dataInfo = new Object[1][3];
                dataInfo[0][0] = item.getItemDescription();
                dataInfo[0][1] = "$ " + item.getItemPrice();
                dataInfo[0][2] = item.getImageLink();
                infoTable.addRow(dataInfo[0]);
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }


    }
}
