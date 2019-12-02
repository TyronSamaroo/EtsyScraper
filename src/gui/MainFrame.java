package gui;

import api.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * MainFrame used to connect all components of the gui together.
 *
 * @author tyronsamaroo
 */
public class MainFrame extends JFrame {


    private SearchBar searchBar;
    private FormPanel formPanel;
    private DisplayArea displayArea;
    private DefaultTableModel infoTable;

    public MainFrame() throws Exception {

        searchBar = new SearchBar();
        formPanel = new FormPanel();
        displayArea = new DisplayArea();

        searchBar.searchButton.addActionListener(e -> {

            try {

//               // System.out.println("Hi");
//                //System.out.println(searchBar.getSearchField().getText());
//                String query = searchBar.getSearchField().getText();
//                Etsy etsy = new Etsy(query);
//                WebpageReader webpageReader = new WebpageReader(etsy.getWebpage());
//                EtsyCleanData data = new EtsyCleanData(webpageReader.rawHTMLFile());
//                OutputData outputData = new OutputData(webpageReader.rawHTMLFile(), "testnov25125pm.txt");
//                outputData.storeOutput();
//                String stringToSplitPrice = data.cleanFileForPrice();
//                String stringToSplitDescription = data.cleanFileForDescription();
//                String stringToSplitImageSrc = data.cleanFileForImageSrc();
//
//                String[] priceArray;
//                String[] descriptionArray;
//                String[] imageLinkArray;
//                priceArray = stringToSplitPrice.split("\n");
//                descriptionArray = stringToSplitDescription.split("\n");
//                imageLinkArray = stringToSplitImageSrc.split("\n");
//
//                ArrayList<ItemData> itemData = new ArrayList<>();
//                for (int i = 0; i < priceArray.length; i++) {
//                    String price = priceArray[i];
//                    String description = descriptionArray[i];
//                    String image = imageLinkArray[i];
//                    ItemData item = new ItemData(description,price,image);
//                    itemData.add(item);
//                }
//
//                String[] header = { "Description", "Price", "Link" };
//                infoTable = new DefaultTableModel(header,0);
//
//
//
//
//                for(ItemData item: itemData){
//
//
//                    Object[][] dataInfo = new Object[1][3];
//                    dataInfo[0][0] = item.getItemDescription();
//                    dataInfo[0][1] = "$ " + item.getItemPrice();
//                    dataInfo[0][2] = item.getImageLink();
//                    infoTable.addRow(dataInfo[0]);
//
//
//                }
//
//
//                JTable table = new JTable(infoTable);
//
//                add(new JScrollPane(table));
//







            } catch (Exception ex) {
                ex.printStackTrace();
            }




        });





        setLayout(new BorderLayout());
        add(searchBar, BorderLayout.NORTH);
        add(formPanel, BorderLayout.WEST);
        add(displayArea,BorderLayout.CENTER);





        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }
}
