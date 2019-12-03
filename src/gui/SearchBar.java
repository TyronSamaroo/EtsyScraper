package gui;

import api.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * SearchBar is where the user input a search criteria for Etsy.
 *
 * @author tyronsamaroo
 */
public class SearchBar extends JPanel implements ActionListener {

    private JLabel searchLabel;
    private JTextField searchField;
    public JButton searchButton;
    private DefaultTableModel infoTable;

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


        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(searchLabel);
        add(searchField);
        add(searchButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            //System.out.println(searchField.getText());
            String result = searchField.getText();
            Etsy etsy = new Etsy(searchField.getText());
            WebpageReader webpageReader = new WebpageReader(etsy.getWebpage());
            EtsyCleanData data = new EtsyCleanData(webpageReader.rawHTMLFile());
            OutputData outputData = new OutputData(webpageReader.rawHTMLFile(), result +".txt");
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

            ArrayList<ItemData> itemData = new ArrayList<>();
            for (int i = 0; i < priceArray.length; i++) {
                String price = priceArray[i];
                String description = descriptionArray[i];
                String image = imageLinkArray[i];
                ItemData item = new ItemData(description,price,image);
                itemData.add(item);
            }

            String[] header = { "Description", "Price", "Link" };
            infoTable = new DefaultTableModel(header,0);




            for(ItemData item: itemData){


                Object[][] dataInfo = new Object[1][3];
                dataInfo[0][0] = item.getItemDescription();
                dataInfo[0][1] = "$ " + item.getItemPrice();
                dataInfo[0][2] = item.getImageLink();
                infoTable.addRow(dataInfo[0]);


            }

            JTable table = new JTable(infoTable);

            add(new JScrollPane(table));

            revalidate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
