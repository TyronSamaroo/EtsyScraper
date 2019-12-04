package gui;

import api.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
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


       formPanel.downloadBtn.addActionListener(e -> {
           String[] header = { "Description", "Price", "Link" };

          // System.out.println(searchBar.table.getSelectedRow());
           //searchBar.table.getValueAt(searchBar.table.getSelectedRow(),searchBar.table.getSelectedColumn());
           System.out.println(searchBar.table.getValueAt(searchBar.table.getSelectedRow(),2));
           String img = (String) searchBar.table.getValueAt(searchBar.table.getSelectedRow(),2);
           String name = ((String) searchBar.table.getValueAt(searchBar.table.getSelectedRow(),0)).trim();



           ImageDownload imageDownload = new ImageDownload();
           String imageDir = "data/image/";


           String filename = name;
           System.out.println(name);

           imageDownload.downloadImage(img,imageDir + name + ".jpg");

          // System.out.println(searchBar.infoTable.getValueAt(searchBar.table.getSelectedRow(),2));


       });

        searchBar.searchButton.addActionListener(e -> {

            try {
                revalidate();

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
        add(displayArea,BorderLayout.EAST);


        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }

    public static void downloadImage(int row){

    }

    public static String img(int id){
    return "A";
    }
}
