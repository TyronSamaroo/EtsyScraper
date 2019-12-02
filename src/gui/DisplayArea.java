package gui;

import api.Etsy;
import api.EtsyCleanData;
import api.OutputData;
import api.WebpageReader;

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
    JPanel panel = new JPanel();

    private JTextField searchField;

    public DisplayArea() throws Exception {
        Dimension dim = getPreferredSize();
        System.out.println(dim);
        dim.width = 250;
        setPreferredSize(dim);

        String[][] rec = {
                { "1", "Steve", "AUS" },
                { "2", "Virat", "IND" },
                { "3", "Kane", "NZ" },
                { "4", "David", "AUS" },
                { "5", "Ben", "ENG" },
                { "6", "Eion", "ENG" },
        };




        Etsy etsy = new Etsy("car");
        //etsy.getWebpage();
        //System.out.println(etsy.getWebpage());
        WebpageReader webpageReader = new WebpageReader(etsy.getWebpage());
        //System.out.println(webpageReader.rawHTMLFile());

        EtsyCleanData data = new EtsyCleanData(webpageReader.rawHTMLFile());
        OutputData outputData = new OutputData(webpageReader.rawHTMLFile(), "testnov25125pm.txt");
        outputData.storeOutput();


        // System.out.println(data.getFileToClean());

        //System.out.println(webpageReader.rawHTMLFile());
        //System.out.println(data.cleanFileForPrice());
        //System.out.println(data.cleanFileForImageSrc());

        //System.out.println(data.cleanFileForDescription());
        //System.out.print(data.cleanFileForDescription() + data.cleanFileForImageSrc() + data.cleanFileForPrice());
        //System.out.println(data.cleanFileForPrice());
        //System.out.println(data.cleanFileForPrice().split("\n").length);

        String stringToSplitPrice = data.cleanFileForPrice();
        String stringToSplitDescription = data.cleanFileForDescription();
        String stringToSplitImageSrc = data.cleanFileForImageSrc();

        String[] priceArray;
        String[] descriptionArray;
        String[] imageLinkArray;

        priceArray = stringToSplitPrice.split("\n");
        descriptionArray = stringToSplitDescription.split("\n");
        imageLinkArray = stringToSplitImageSrc.split("\n");


        System.out.println("test" + priceArray[0]);
        Hashtable<Integer, ArrayList<String>> tablee = new Hashtable<>();


        for (int i = 0; i < data.cleanFileForPrice().split("\n").length; i++) {
            ArrayList<String> params = new ArrayList<>();
            params.add(descriptionArray[i]);
            params.add(priceArray[i]);
            params.add(imageLinkArray[i]);

            tablee.put(i,params);
            //System.out.println(priceArray[i]);
            System.out.println(params);
        }

        System.out.println(data.cleanFileForPrice().split("\n").length);
        System.out.println(data.cleanFileForDescription().toString().split("\n").length);
        System.out.println(data.cleanFileForImageSrc().split("\n").length);
//        System.out.println(table.entrySet());
//        System.out.println(table.entrySet().size());


//        for (int i = 0; i < table.entrySet().size() - 1; i++) {
//            System.out.println(table.elements().asIterator().next().get(i));
//
//        }
        System.out.println(tablee.entrySet());
        String[] header = { "Description", "Title", "Link" };
        DefaultTableModel model = new DefaultTableModel(new Object[][] {
                { "some", "text" ,"dd"}, { "any", "text" }, { "even", "more" },
                { "text", "strings" }, { "and", "other" }, { "text", "values" } },
                new Object[] { "Description", "Title","Link" });

        JTable table = new JTable(model);


        //JTable table = new JTable(rec, header);
        add(new JScrollPane(table));



    }
}
